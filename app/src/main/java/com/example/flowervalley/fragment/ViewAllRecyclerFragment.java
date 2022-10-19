package com.example.flowervalley.fragment;

import static android.content.ContentValues.TAG;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.flowervalley.MainActivity;
import com.example.flowervalley.R;
import com.example.flowervalley.Utils;
import com.example.flowervalley.adapter.FlowerAdapter;
import com.example.flowervalley.adapter.FlowerRecycleAdapter;
import com.example.flowervalley.model.Flower;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ViewAllRecyclerFragment extends Fragment {
    private Flower flower;
    private  RecyclerView recyclerView;
    private ArrayList<Flower> arrFlower;
    private DatabaseReference mDatabaseRef;
    AppCompatImageView back_icon;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_all_recycler, container, false);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("flowers");
        back_icon=view.findViewById(R.id.back_icon);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.replaceFragment(new HomeFragment(),getActivity());
            }
        });
        recyclerView=view.findViewById(R.id.flower_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        arrFlower=new ArrayList<>();
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrFlower.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    flower = postSnapshot.getValue(Flower.class);
                    Log.i(TAG, "onCreateView: Data > " + postSnapshot.getValue());
                    arrFlower.add(flower);
                }
                recyclerView.setAdapter(new FlowerAdapter(arrFlower, getContext()));

            }
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(new FlowerRecycleAdapter(arrFlower,getContext()));


        return view;
    }

}