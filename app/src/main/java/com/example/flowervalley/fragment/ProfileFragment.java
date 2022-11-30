package com.example.flowervalley.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.flowervalley.MainActivity;
import com.example.flowervalley.R;
import com.example.flowervalley.SharedPreferenceManager;
import com.example.flowervalley.Utils;
import com.example.flowervalley.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    private AppCompatTextView user_name, user_phone, user_email;
    private DatabaseReference mDatabaseRef;
    private FirebaseDatabase firebaseDatabase;
    private AppCompatImageView profileCart;
    private AppCompatImageView profileBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
        MainActivity.bottomNavigationView.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        user_name = view.findViewById(R.id.profile_name);
        user_phone = view.findViewById(R.id.profile_phone);
        user_email = view.findViewById(R.id.profile_email);
        profileCart = view.findViewById(R.id.profile_cart);
        profileBack =view.findViewById(R.id.profile_back);

        profileCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.replaceFragment(new CartFragment(), getActivity());
                Toast.makeText(getContext(), " Your Cart Items. ", Toast.LENGTH_SHORT).show();
            }
        });

        profileBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MainActivity.bottomNavigationView.setVisibility(View.VISIBLE);

                Utils.replaceFragment(new HomeFragment(), getActivity());
            }
        });


        SharedPreferenceManager sharedPreferenceManager = new SharedPreferenceManager(getContext());
        user_name.setText(sharedPreferenceManager.getName());
        user_phone.setText(sharedPreferenceManager.getPhone());
        user_email.setText(sharedPreferenceManager.getEmail());


        return view;
    }
}