package com.example.flowervalley.fragment;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.flowervalley.MainActivity;
import com.example.flowervalley.R;
import com.example.flowervalley.Utils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginFragment extends Fragment {
    private static final String TAG = "LoginFragment";
    private MaterialButton btnLogin;
    private TextInputEditText etMobile;
    private FirebaseAuth mAuth;
    private AppCompatTextView signUp;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(getContext().getApplicationContext());
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        MainActivity.bottomNavigationView.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        btnLogin = view.findViewById(R.id.btn_login);
        etMobile = view.findViewById(R.id.mobile);
        signUp = view.findViewById(R.id.sign_up);

        mAuth = FirebaseAuth.getInstance();
        mAuth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(false);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etMobile.getText().toString().trim().equalsIgnoreCase("")) {
                    Snackbar.make(btnLogin, "Please Enter Mobile Number.", Snackbar.LENGTH_SHORT).show();
                    etMobile.requestFocus();
                } else if (etMobile.getText().toString().length() != 10) {
                    Snackbar.make(btnLogin, "Please Enter Valid Mobile Number.", Snackbar.LENGTH_SHORT).show();
                    etMobile.requestFocus();
                } else {
                    String mobileNumber = "+91" + etMobile.getText().toString().trim();
                    sendOTP(mobileNumber);
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.replaceFragment(new RagisterFragment(), getActivity());
            }
        });

        return view;
    }


    private void sendOTP(String mobile) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(mobile)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(getActivity())// Activity (for callback binding)


                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                Log.i(TAG, "onVerificationCompleted: " + phoneAuthCredential.getSmsCode());

                                Toast.makeText(getContext(), "Aapka Code Send ho gya hai. ", Toast.LENGTH_SHORT).show();
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                FragmentTransaction ft = fragmentManager.beginTransaction();
                                ft.replace(R.id.frame_Layout, new HomeFragment());
                                ft.commit();
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Log.i(TAG, "onVerificationFailed: " + e.getMessage());
                                Toast.makeText(getContext(), e.getMessage() + "", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(s, forceResendingToken);
                                Log.i(TAG, "onCodeSent: " + s);
                                OTPVerificationFragment otpVerificationFragment = new OTPVerificationFragment();

                                Bundle bundle = new Bundle();
                                bundle.putString("token", s);

                                // Mobile number added for login
                                bundle.putString("mobile", mobile);

                                otpVerificationFragment.setArguments(bundle);

                                Utils.replaceFragment(otpVerificationFragment, getActivity());

                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

}
