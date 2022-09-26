package com.example.flowervalley.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flowervalley.MainActivity;
import com.example.flowervalley.R;
import com.example.flowervalley.Utils;
import com.example.flowervalley.adapter.ViewAllFlowerAdapter;
import com.example.flowervalley.model.FlowerRecyclerModal;

import java.util.ArrayList;


public class ViewAllRecyclerFragment extends Fragment {

    AppCompatImageView arrow;

    RecyclerView recyclerView;
    ArrayList<FlowerRecyclerModal> arrFlower;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_all_recycler, container, false);

        arrow.findViewById(R.id.arrow_popular_items);



        recyclerView=view.findViewById(R.id.flower_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        arrFlower=new ArrayList<>();


        arrFlower.add(new FlowerRecyclerModal(766,"https://images.unsplash.com/photo-1535850836387-0f9dfce30846?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zmxvd2VycyUyMHdoaXRlJTIwYmFja2dyb3VuZHxlbnwwfHwwfHw%3D&w=1000&q=80","Rose"));
        arrFlower.add(new FlowerRecyclerModal(56,"https://img.freepik.com/premium-vector/marigold-flowers-isolated-white-background-illustration_316696-12.jpg?w=2000","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(46,"https://previews.123rf.com/images/vlpopovich/vlpopovich1503/vlpopovich150300002/37947615-big-flower-bouquet-from-pink-roses-isolated-on-white-background-closeup-.jpg?fj=1","Bouquet"));
        arrFlower.add(new FlowerRecyclerModal(446,"https://img.freepik.com/premium-photo/closeup-lily-valley-flowers-white_87646-6712.jpg?w=2000","lily"));
        arrFlower.add(new FlowerRecyclerModal(56,"https://s3.envato.com/files/249322934/145.jpg","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(16,"https://www.proflowers.com/blog/wp-content/uploads/2016/01/white-dianthus.jpg","Lily"));
        arrFlower.add(new FlowerRecyclerModal(76,"https://images.unsplash.com/photo-1535850836387-0f9dfce30846?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zmxvd2VycyUyMHdoaXRlJTIwYmFja2dyb3VuZHxlbnwwfHwwfHw%3D&w=1000&q=80","Rose"));
        arrFlower.add(new FlowerRecyclerModal(56,"https://img.freepik.com/premium-vector/marigold-flowers-isolated-white-background-illustration_316696-12.jpg?w=2000","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(446,"https://previews.123rf.com/images/vlpopovich/vlpopovich1503/vlpopovich150300002/37947615-big-flower-bouquet-from-pink-roses-isolated-on-white-background-closeup-.jpg?fj=1","Bouquet"));
        arrFlower.add(new FlowerRecyclerModal(46,"https://img.freepik.com/premium-photo/closeup-lily-valley-flowers-white_87646-6712.jpg?w=2000","lily"));
        arrFlower.add(new FlowerRecyclerModal(56,"https://s3.envato.com/files/249322934/145.jpg","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(15,"https://www.proflowers.com/blog/wp-content/uploads/2016/01/white-dianthus.jpg","Lily"));
        arrFlower.add(new FlowerRecyclerModal(76,"https://images.unsplash.com/photo-1535850836387-0f9dfce30846?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zmxvd2VycyUyMHdoaXRlJTIwYmFja2dyb3VuZHxlbnwwfHwwfHw%3D&w=1000&q=80","Rose"));
        arrFlower.add(new FlowerRecyclerModal(56,"https://img.freepik.com/premium-vector/marigold-flowers-isolated-white-background-illustration_316696-12.jpg?w=2000","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(46,"https://previews.123rf.com/images/vlpopovich/vlpopovich1503/vlpopovich150300002/37947615-big-flower-bouquet-from-pink-roses-isolated-on-white-background-closeup-.jpg?fj=1","Bouquet"));
        arrFlower.add(new FlowerRecyclerModal(46,"https://img.freepik.com/premium-photo/closeup-lily-valley-flowers-white_87646-6712.jpg?w=2000","lily"));
        arrFlower.add(new FlowerRecyclerModal(156,"https://s3.envato.com/files/249322934/145.jpg","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(15,"https://www.proflowers.com/blog/wp-content/uploads/2016/01/white-dianthus.jpg","Lily"));
        arrFlower.add(new FlowerRecyclerModal(76,"https://images.unsplash.com/photo-1535850836387-0f9dfce30846?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zmxvd2VycyUyMHdoaXRlJTIwYmFja2dyb3VuZHxlbnwwfHwwfHw%3D&w=1000&q=80","Rose"));
        arrFlower.add(new FlowerRecyclerModal(56,"https://img.freepik.com/premium-vector/marigold-flowers-isolated-white-background-illustration_316696-12.jpg?w=2000","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(46,"https://previews.123rf.com/images/vlpopovich/vlpopovich1503/vlpopovich150300002/37947615-big-flower-bouquet-from-pink-roses-isolated-on-white-background-closeup-.jpg?fj=1","Bouquet"));
        arrFlower.add(new FlowerRecyclerModal(46,"https://img.freepik.com/premium-photo/closeup-lily-valley-flowers-white_87646-6712.jpg?w=2000","lily"));
        arrFlower.add(new FlowerRecyclerModal(16,"https://s3.envato.com/files/249322934/145.jpg","Marigold"));
        arrFlower.add(new FlowerRecyclerModal(56,"https://www.proflowers.com/blog/wp-content/uploads/2016/01/white-dianthus.jpg","Lily"));


        recyclerView.setAdapter(new ViewAllFlowerAdapter(arrFlower,getContext()));


        return view;
    }

}