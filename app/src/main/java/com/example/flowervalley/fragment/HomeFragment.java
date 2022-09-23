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
        slideModels.add(new SlideModel("https://res.cloudinary.com/dwzmsvp7f/image/fetch/q_75,f_auto,w_1316/https%3A%2F%2Fmedia.insider.in%2Fimage%2Fupload%2Fc_crop%2Cg_custom%2Fv1497600806%2Fs8dcsmos3up7qaucx8jp.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://img.traveltriangle.com/blog/wp-content/uploads/2017/03/cover2.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("2wCEAAkGBxMSEhUSExMWFRUXFxUVGBgYGBgYGBcVFRUWFxUWFhgaHSggGBolHRUVITEhJSorLy4uGB8zODMtNygtLisBCgoKDg0OGxAQGy0lHyUtLS0tLy0vLS0tLS0tLS0tMC0tLS0tLS0tLS8tLS0tLy0wLS0tLS0tLy0tLS0tLS0tLf", ScaleTypes.FIT));


        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ92_50-_aP9QSJvZbQ7kVDmjlHEQbq1pGDX0vqsC-ceQ&s", ScaleTypes.FIT));

        slideModels.add(new SlideModel("https://img.traveltriangle.com/blog/wp-content/uploads/2017/03/cover2.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("2wCEAAkGBxMSEhUSExMWFRUXFxUVGBgYGBgYGBcVFRUWFxUWFhgaHSggGBolHRUVITEhJSorLy4uGB8zODMtNygtLisBCgoKDg0OGxAQGy0lHyUtLS0tLy0vLS0tLS0tLS0tMC0tLS0tLS0tLS8tLS0tLy0wLS0tLS0tLy0tLS0tLS0tLf", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0nfEugt7zh56d2EctNfjOoQZ-pBCUaguWyg&usqp=CAU", ScaleTypes.FIT));

        slideModels.add(new SlideModel("https://www.trekupindia.com/wp-content/uploads/2022/06/towards-valley-of-flowers-1.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2a3dgMOmuC-8OuMuBjoL9J6whE-QZ9ZK8rA&usqp=CAU", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVUP7Wqvx2cagcvUNUfzEHqMZyqk4c27GKkA&usqp=CAU", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        imageSlider.startSliding(2000);

        recyclerView=view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        arrFlower=new ArrayList<>();
        arrFlower.add(new FlowerRecyclerModal(766,"https://bit.ly/3fLJf72","Rose"));
        arrFlower.add(new FlowerRecyclerModal(446,"https://www.freepnglogos.com/pics/flowers","Lotush"));
        arrFlower.add(new FlowerRecyclerModal(156,"https://www.freepnglogos.com/pics/flowers","Chamali"));
        arrFlower.add(new FlowerRecyclerModal(256,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2a3dgMOmuC-8OuMuBjoL9J6whE-QZ9ZK8rA&usqp=CAU","rose"));
        arrFlower.add(new FlowerRecyclerModal(453,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0nfEugt7zh56d2EctNfjOoQZ-pBCUaguWyg&usqp=CAU","rose"));
        arrFlower.add(new FlowerRecyclerModal(252,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2a3dgMOmuC-8OuMuBjoL9J6whE-QZ9ZK8rA&usqp=CAU","rose"));
        arrFlower.add(new FlowerRecyclerModal(766,"https://bit.ly/3fLJf72","rose"));
        arrFlower.add(new FlowerRecyclerModal(446,"https://www.freepnglogos.com/pics/flowers","merigold"));
        arrFlower.add(new FlowerRecyclerModal(156,"https://www.freepnglogos.com/pics/flowers","Hello"));
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