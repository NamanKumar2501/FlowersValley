package com.example.flowervalley.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flowervalley.R;
import com.example.flowervalley.Utils;
import com.example.flowervalley.adapter.FlowerRecycleAdapter;
import com.example.flowervalley.model.Flower;

import java.util.ArrayList;


public class ViewAllRecyclerFragment extends Fragment {
    RecyclerView flowerRecyclerview;
    ArrayList<Flower> flowers;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_all_recycler, container, false);

//        flowerRecyclerview=view.findViewById(R.id.arrow_popular_items);
//        flowers = new ArrayList<>();


//
//        arrFlower.add(new Flower(766,"https://images.unsplash.com/photo-1535850836387-0f9dfce30846?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zmxvd2VycyUyMHdoaXRlJTIwYmFja2dyb3VuZHxlbnwwfHwwfHw%3D&w=1000&q=80","Rose"));
//        arrFlower.add(new Flower(56,"https://img.freepik.com/premium-vector/marigold-flowers-isolated-white-background-illustration_316696-12.jpg?w=2000","Marigold"));
//        arrFlower.add(new Flower(46,"https://previews.123rf.com/images/vlpopovich/vlpopovich1503/vlpopovich150300002/37947615-big-flower-bouquet-from-pink-roses-isolated-on-white-background-closeup-.jpg?fj=1","Bouquet"));
//        arrFlower.add(new Flower(446,"https://img.freepik.com/premium-photo/closeup-lily-valley-flowers-white_87646-6712.jpg?w=2000","lily"));
//        arrFlower.add(new Flower(56,"https://s3.envato.com/files/249322934/145.jpg","Marigold"));
//        arrFlower.add(new Flower(16,"https://www.proflowers.com/blog/wp-content/uploads/2016/01/white-dianthus.jpg","Lily"));
//        arrFlower.add(new Flower(76,"https://images.unsplash.com/photo-1535850836387-0f9dfce30846?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zmxvd2VycyUyMHdoaXRlJTIwYmFja2dyb3VuZHxlbnwwfHwwfHw%3D&w=1000&q=80","Rose"));
//        arrFlower.add(new Flower(56,"https://img.freepik.com/premium-vector/marigold-flowers-isolated-white-background-illustration_316696-12.jpg?w=2000","Marigold"));
//        arrFlower.add(new Flower(446,"https://previews.123rf.com/images/vlpopovich/vlpopovich1503/vlpopovich150300002/37947615-big-flower-bouquet-from-pink-roses-isolated-on-white-background-closeup-.jpg?fj=1","Bouquet"));
//        arrFlower.add(new Flower(46,"https://img.freepik.com/premium-photo/closeup-lily-valley-flowers-white_87646-6712.jpg?w=2000","lily"));
//        arrFlower.add(new Flower(56,"https://s3.envato.com/files/249322934/145.jpg","Marigold"));
//        arrFlower.add(new Flower(15,"https://www.proflowers.com/blog/wp-content/uploads/2016/01/white-dianthus.jpg","Lily"));
//        arrFlower.add(new Flower(76,"https://images.unsplash.com/photo-1535850836387-0f9dfce30846?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zmxvd2VycyUyMHdoaXRlJTIwYmFja2dyb3VuZHxlbnwwfHwwfHw%3D&w=1000&q=80","Rose"));
//        arrFlower.add(new Flower(56,"https://img.freepik.com/premium-vector/marigold-flowers-isolated-white-background-illustration_316696-12.jpg?w=2000","Marigold"));
//        arrFlower.add(new Flower(46,"https://previews.123rf.com/images/vlpopovich/vlpopovich1503/vlpopovich150300002/37947615-big-flower-bouquet-from-pink-roses-isolated-on-white-background-closeup-.jpg?fj=1","Bouquet"));
//        arrFlower.add(new Flower(46,"https://img.freepik.com/premium-photo/closeup-lily-valley-flowers-white_87646-6712.jpg?w=2000","lily"));
//        arrFlower.add(new Flower(156,"https://s3.envato.com/files/249322934/145.jpg","Marigold"));
//        arrFlower.add(new Flower(15,"https://www.proflowers.com/blog/wp-content/uploads/2016/01/white-dianthus.jpg","Lily"));
//        arrFlower.add(new Flower(76,"https://images.unsplash.com/photo-1535850836387-0f9dfce30846?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zmxvd2VycyUyMHdoaXRlJTIwYmFja2dyb3VuZHxlbnwwfHwwfHw%3D&w=1000&q=80","Rose"));
//        arrFlower.add(new Flower(56,"https://img.freepik.com/premium-vector/marigold-flowers-isolated-white-background-illustration_316696-12.jpg?w=2000","Marigold"));
//        arrFlower.add(new Flower(46,"https://previews.123rf.com/images/vlpopovich/vlpopovich1503/vlpopovich150300002/37947615-big-flower-bouquet-from-pink-roses-isolated-on-white-background-closeup-.jpg?fj=1","Bouquet"));
//        arrFlower.add(new Flower(46,"https://img.freepik.com/premium-photo/closeup-lily-valley-flowers-white_87646-6712.jpg?w=2000","lily"));
//        arrFlower.add(new Flower(16,"https://s3.envato.com/files/249322934/145.jpg","Marigold"));
//        arrFlower.add(new Flower(56,"https://www.proflowers.com/blog/wp-content/uploads/2016/01/white-dianthus.jpg","Lily"));
//

//        flowerRecyclerview.setAdapter(new FlowerRecycleAdapter(flowers, getContext()));


        return view;
    }

}