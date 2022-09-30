package com.example.flowervalley.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.flowervalley.MainActivity;
import com.example.flowervalley.R;
import com.example.flowervalley.SharedPreferenceManager;
import com.example.flowervalley.adapter.FlowerRecycleAdapter;
import com.example.flowervalley.model.Banner;
import com.example.flowervalley.model.FlowerRecyclerModal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<FlowerRecyclerModal> arrFlower;
    private ImageSlider imageSlider;
    private RecyclerView recyclerView;
    private AppCompatTextView view_all;

    private SharedPreferenceManager preferenceManager;
    private static final String TAG = "HomeFragment";
    private DatabaseReference mDatabaseRef;
    private Banner banner;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            MainActivity.bottomNavigationView.setVisibility(View.VISIBLE);

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        imageSlider = view.findViewById(R.id.image_slider);
        recyclerView=view.findViewById(R.id.recycler_view);
        view_all=view.findViewById(R.id.view_all);



        preferenceManager = new SharedPreferenceManager(getContext());
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("banners");

        imageSlider.setImageList(slideModels);
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    banner = postSnapshot.getValue(Banner.class);
                    Log.i(TAG, "onCreateView: Data > " + postSnapshot.getValue());
                    slideModels.add(new SlideModel("" + banner.getImageUrl(),  ScaleTypes.FIT));
                }
                imageSlider.setImageList(slideModels);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        arrFlower=new ArrayList<>();
        arrFlower.add(new FlowerRecyclerModal(766,"https://images.unsplash.com/photo-1535850836387-0f9dfce30846?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zmxvd2VycyUyMHdoaXRlJTIwYmFja2dyb3VuZHxlbnwwfHwwfHw%3D&w=1000&q=80","Rose"));
        arrFlower.add(new FlowerRecyclerModal(156,"https://img.freepik.com/premium-vector/marigold-flowers-isolated-white-background-illustration_316696-12.jpg?w=2000","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(446,"https://previews.123rf.com/images/vlpopovich/vlpopovich1503/vlpopovich150300002/37947615-big-flower-bouquet-from-pink-roses-isolated-on-white-background-closeup-.jpg?fj=1","Bouquet"));
        arrFlower.add(new FlowerRecyclerModal(446,"https://img.freepik.com/premium-photo/closeup-lily-valley-flowers-white_87646-6712.jpg?w=2000","lily"));
        arrFlower.add(new FlowerRecyclerModal(156,"https://s3.envato.com/files/249322934/145.jpg","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(156,"https://www.proflowers.com/blog/wp-content/uploads/2016/01/white-dianthus.jpg","Lily"));
        arrFlower.add(new FlowerRecyclerModal(766,"https://images.unsplash.com/photo-1535850836387-0f9dfce30846?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zmxvd2VycyUyMHdoaXRlJTIwYmFja2dyb3VuZHxlbnwwfHwwfHw%3D&w=1000&q=80","Rose"));
        arrFlower.add(new FlowerRecyclerModal(156,"https://img.freepik.com/premium-vector/marigold-flowers-isolated-white-background-illustration_316696-12.jpg?w=2000","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(446,"https://previews.123rf.com/images/vlpopovich/vlpopovich1503/vlpopovich150300002/37947615-big-flower-bouquet-from-pink-roses-isolated-on-white-background-closeup-.jpg?fj=1","Bouquet"));
        arrFlower.add(new FlowerRecyclerModal(446,"https://img.freepik.com/premium-photo/closeup-lily-valley-flowers-white_87646-6712.jpg?w=2000","lily"));
        arrFlower.add(new FlowerRecyclerModal(156,"https://s3.envato.com/files/249322934/145.jpg","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(156,"https://www.proflowers.com/blog/wp-content/uploads/2016/01/white-dianthus.jpg","Lily"));


        recyclerView.setAdapter(new FlowerRecycleAdapter(arrFlower, getContext()));


        view_all.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MainActivity.bottomNavigationView.setVisibility(View.GONE);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.frame_Layout, new ViewAllRecyclerFragment());
                ft.commit();
            }
        });

        return view;
    }
}