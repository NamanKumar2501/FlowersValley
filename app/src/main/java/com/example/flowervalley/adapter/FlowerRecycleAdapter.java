package com.example.flowervalley.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flowervalley.R;
import com.example.flowervalley.model.Flower;

import java.util.ArrayList;

public class FlowerRecycleAdapter extends RecyclerView.Adapter<FlowerRecycleAdapter.ViewHolder>{
    ArrayList<Flower> arrFlower;
    Context context;

    public FlowerRecycleAdapter(ArrayList<Flower> arrFlower, Context context) {
        this.arrFlower = arrFlower;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.flower_design_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerRecycleAdapter.ViewHolder holder, int position) {
        Flower flower=arrFlower.get(position);

        holder.flower_name.setText(""+flower.getFlowerName());
        holder.flower_price.setText(""+flower.getFlowerPrice());
        Glide.with(context)
                .load(flower.getFlowerImageUrl())
                .into(holder.flower_img);
    }

    @Override
    public int getItemCount() {
        return arrFlower.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView flower_img;
        AppCompatTextView flower_name,flower_price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flower_img=itemView.findViewById(R.id.flower_image);
            flower_name=itemView.findViewById(R.id.flower_name1);
            flower_price=itemView.findViewById(R.id.flower_price);
        }
    }
}
