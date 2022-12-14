package com.example.flowervalley;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.flowervalley.fragment.CartFragment;
import com.example.flowervalley.fragment.FavoriteFragment;
import com.example.flowervalley.fragment.HomeFragment;
import com.example.flowervalley.fragment.LoginFragment;
import com.example.flowervalley.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

   public static BottomNavigationView bottomNavigationView;
   private SharedPreferenceManager sharedPreferenceManager;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     bottomNavigationView =findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.favorite:
                        replaceFragment(new FavoriteFragment());
                        break;
                    case R.id.cart:
                        replaceFragment(new CartFragment());
                        break;
                    case R.id.person:
                        replaceFragment(new ProfileFragment());
                        break;
                }
                return true;
            }
        });
        FirebaseApp.initializeApp(getApplicationContext());

        sharedPreferenceManager = new SharedPreferenceManager(this);

        if (sharedPreferenceManager.getName() != null) {
            replaceFragment(new HomeFragment());
        } else {
            replaceFragment(new LoginFragment());
        }
    }

    void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_Layout,fragment);
        fragmentTransaction.commit();

    }

    public void replaceFragment(Fragment fragment, Context context) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame_Layout, fragment);
        ft.commit();
    }
}


