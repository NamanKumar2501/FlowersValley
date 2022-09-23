package com.example.flowervalley;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.flowervalley.fragment.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

public class Utils {

        public static void replaceFragment(HomeFragment fragment, FragmentActivity activity) {
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.frame_Layout, fragment);
            ft.commit();
        }
}
