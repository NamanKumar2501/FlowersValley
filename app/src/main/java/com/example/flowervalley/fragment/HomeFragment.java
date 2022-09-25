package com.example.flowervalley.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.flowervalley.MainActivity;
import com.example.flowervalley.R;
import com.example.flowervalley.adapter.FlowerRecycleAdapter;
import com.example.flowervalley.model.FlowerRecyclerModal;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<FlowerRecyclerModal> arrFlower;
    ImageSlider imageSlider;
    RecyclerView recyclerView;

    AppCompatTextView view_all;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity.bottomNavigationView.setVisibility(View.VISIBLE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        imageSlider = view.findViewById(R.id.image_slider);

        // ------ Create List For Images ------------

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://www.trekupindia.com/wp-content/uploads/2022/06/towards-valley-of-flowers-1.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://img.traveltriangle.com/blog/wp-content/uploads/2017/03/cover2.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.rishikeshpackages.in/trek/valley-of-flowers/2.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.holidify.com/images/bgImages/VALLEY-OF-FLOWERS.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.thevalleyofflowers.com/wp-content/uploads/2017/02/best-time-to-visit.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://img.traveltriangle.com/blog/wp-content/uploads/2017/03/cover2.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.rishikeshpackages.in/trek/valley-of-flowers/2.jpg", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        imageSlider.startSliding(1000);


        recyclerView=view.findViewById(R.id.recycler_view);
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


        view_all=view.findViewById(R.id.view_all);
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