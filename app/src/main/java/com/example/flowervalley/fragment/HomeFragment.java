package com.example.flowervalley.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.flowervalley.MainActivity;
import com.example.flowervalley.R;
import com.example.flowervalley.SharedPreferenceManager;
import com.example.flowervalley.Utils;
import com.example.flowervalley.adapter.FlowerAdapter;
import com.example.flowervalley.model.Banner;
import com.example.flowervalley.model.Flower;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<Flower> flowers;
    private RecyclerView flowerRecyclerview;
    private ImageSlider imageSlider;
    private AppCompatTextView view_all;
    private SharedPreferenceManager preferenceManager;
    private static final String TAG = "HomeFragment";
    private DatabaseReference mDatabaseRef;
    private FirebaseDatabase firebaseDatabase;
    private Banner banner;
    private Flower flower;
    private SearchView searchView;
    private ListView searchFlowerList;
    private RelativeLayout mainLayout;

    public HomeFragment() {
        // Required empty public constructor
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        MainActivity.bottomNavigationView.setVisibility(View.VISIBLE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider = view.findViewById(R.id.image_slider);
        flowerRecyclerview=view.findViewById(R.id.recycler_view);
        view_all=view.findViewById(R.id.view_all);

        searchView = view.findViewById(R.id.search_bar);
        mainLayout = view.findViewById(R.id.main_layout);
        searchFlowerList = view.findViewById(R.id.search_list);


        preferenceManager = new SharedPreferenceManager(getContext());
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseRef = firebaseDatabase.getReference("banners");
        flowers = new ArrayList<>();

        // --------------- Banner ----------

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                slideModels.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    banner = postSnapshot.getValue(Banner.class);
                    Log.i(TAG, "onCreateView: Data > " + postSnapshot.getValue());
                    slideModels.add(new SlideModel("" + banner.getImageUrl(), ScaleTypes.FIT));
                }
                imageSlider.setImageList(slideModels);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // -------------- Flowers ------------

        firebaseDatabase.getReference("flowers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                flowers.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    flower = postSnapshot.getValue(Flower.class);
                    Log.i(TAG, "onCreateView: Data > " + postSnapshot.getValue());
                    flowers.add(flower);
                }
                flowerRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
                flowerRecyclerview.setAdapter(new FlowerAdapter(flowers, getContext()));
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        // ------- Search View -------

        ArrayAdapter<Flower> flowerArrayAdapter = new ArrayAdapter<>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, flowers);
        searchFlowerList.setAdapter(flowerArrayAdapter);
        searchFlowerList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //flower = flowers.get(i);
                Log.i(TAG, "onItemSelected: " + flowers.get(i).getFlowerId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.e(TAG, "onNothingSelected:" );
            }
        });

        searchFlowerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i(TAG, "onItemClick: " + flowers.get(i).getFlowerId());


                Utils.replaceFragment(new FlowerDetailFragment(), getActivity());
            }
        });


        searchView.setQueryHint("Red Rose");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i(TAG, "onQueryTextSubmit: " + query);
                if (flowers.contains(query)) {
                    flowerArrayAdapter.getFilter().filter(query);
                } else {
                    Toast.makeText(getContext(), "No Match found", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i(TAG, "onQueryTextChange: " + newText);
                searchFlowerList.setVisibility(View.VISIBLE);
                mainLayout.setVisibility(View.GONE);
                flowerArrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                searchView.onActionViewCollapsed();
                searchFlowerList.setVisibility(View.GONE);
                mainLayout.setVisibility(View.VISIBLE);
                return false;
            }
        });

        // -------- search view complete -------



        view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.bottomNavigationView.setVisibility(View.GONE);
                Utils.replaceFragment(new ViewAllRecyclerFragment(), getActivity());
            }
        });

        Utils.getCartItemCount(preferenceManager.getPhone(), getContext());

        return view;
    }
}