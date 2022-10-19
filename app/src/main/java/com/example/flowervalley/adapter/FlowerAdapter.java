package com.example.flowervalley.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flowervalley.BottomMenuHelper;
import com.example.flowervalley.MainActivity;
import com.example.flowervalley.R;
import com.example.flowervalley.SharedPreferenceManager;
import com.example.flowervalley.Utils;
import com.example.flowervalley.fragment.FlowerDetailFragment;
import com.example.flowervalley.model.Flower;

import java.util.ArrayList;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {
    SharedPreferenceManager sharedPreferenceManager;
    ArrayList<Flower> list;
    Context context;
    int count = 1;

    public FlowerAdapter(ArrayList<Flower> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flower_card_recyclerview, parent, false);

        ViewHolder viewHolder=new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Flower flower = list.get(position);
        holder.flowerName.setText(flower.getFlowerName());
        holder.flowerPrice.setText(flower.getFlowerPrice());
        Glide.with(context)
                .load(flower.getFlowerImageUrl())
                .into(holder.flowerImage);

        sharedPreferenceManager = new SharedPreferenceManager(context);

        holder.addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferenceManager.setItemCounter(count++);
                BottomMenuHelper.showBadge(context, MainActivity.bottomNavigationView, R.id.cart, "" + sharedPreferenceManager.getItemCounter());
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlowerDetailFragment fragment = new FlowerDetailFragment();
                Bundle bundle = new Bundle();

                bundle.putString("flower_id", flower.getFlowerId());

                bundle.putString("flower_name", flower.getFlowerName());
                flower.setFlowerName("");

                bundle.putString("flower_price", flower.getFlowerPrice());
                flower.setFlowerPrice("");

                bundle.putString("flower_about", flower.getFlowerDescription());
                flower.setFlowerDescription("");

                bundle.putString("flower_image", flower.getFlowerImageUrl());
                flower.setFlowerImageUrl("");

                fragment.setArguments(bundle);
                Utils.replaceFragment(fragment, (FragmentActivity) context);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView flowerName, flowerPrice;
        AppCompatImageView flowerImage;
        CardView cardView;
        AppCompatImageButton addItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card);
            flowerName = itemView.findViewById(R.id.flower_name);
            flowerPrice = itemView.findViewById(R.id.flower_price);
            flowerImage = itemView.findViewById(R.id.flower_image);
            addItem = itemView.findViewById(R.id.btn_add_item);

        }
    }
}
