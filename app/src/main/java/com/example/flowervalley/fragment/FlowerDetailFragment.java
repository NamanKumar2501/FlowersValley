package com.example.flowervalley.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.flowervalley.MainActivity;
import com.example.flowervalley.R;
import com.example.flowervalley.Utils;
import com.example.flowervalley.adapter.FlowerAdapter;
import com.example.flowervalley.model.Flower;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FlowerDetailFragment extends Fragment {

    private static final String TAG = "FlowerDetailFragment";
    String flowerId, flowerName,flowerDescription,flowerImageUrl;
    Integer flowerPrice;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    AppCompatImageView flower_image;
    AppCompatTextView flower_name,flower_price,flower_about,back_icon;
    Context context;


    public FlowerDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            flowerId = getArguments().getString("flower_id");
            flowerName=getArguments().getString("flower_name");
            flowerPrice=getArguments().getInt("flower_price");
            flowerDescription=getArguments().getString("flower_about");
            flowerImageUrl=getArguments().getString("flower_image");

        }
        MainActivity.bottomNavigationView.setVisibility(View.VISIBLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flower_detail, container, false);

        flower_image=view.findViewById(R.id.flower_details_image);
        flower_name=view.findViewById(R.id.flower_name);
        flower_price=view.findViewById(R.id.flower_price);
        flower_about=view.findViewById(R.id.flower_about);
        back_icon=view.findViewById(R.id.back_icon);



        if (flowerImageUrl != null){
            Glide.with(getContext())
                    .load(flowerImageUrl)
                    .into(flower_image);
        }


        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.replaceFragment(new HomeFragment(), getActivity());
            }
        });


        firebaseDatabase = FirebaseDatabase.getInstance();

        Log.i(TAG, "onCreateView: "+flower_image);

        if (flowerId != null) {
            databaseReference = firebaseDatabase.getReference("flowers").child(flowerId);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Log.i(TAG, "onDataChange: " + snapshot);

                    flower_name.setText(flowerName);
                    flower_price.setText(String.valueOf("₹ "+ flowerPrice));
                    flower_about.setText(flowerDescription);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.e(TAG, "onCancelled: " + error);
                }

            });



        } else {
            Toast.makeText(getContext(), "Please try again.", Toast.LENGTH_SHORT).show();
        }



        return view;
    }
}