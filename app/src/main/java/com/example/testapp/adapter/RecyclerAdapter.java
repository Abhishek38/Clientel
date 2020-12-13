package com.example.testapp.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testapp.R;
import com.example.testapp.RecyclerClick;
import com.example.testapp.model.recycler_model;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {
    private List<recycler_model> items;
    private final RecyclerClick click;

    public RecyclerAdapter(List<recycler_model> items, RecyclerClick click) {
        this.items = items;
        this.click = click;

        Log.d("DebugAbhi","Adapter constructor is called");
    }


    public static class myViewHolder extends RecyclerView.ViewHolder{
        private final ImageView proImage;
        private final TextView priceText;
        private final TextView Discount;
        private final TextView mName;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d("DebugAbhi","executing viewholder");

            proImage=itemView.findViewById(R.id.Cosmetics_Images);
            priceText=itemView.findViewById(R.id.cosmetics_pricing);
            Discount=itemView.findViewById(R.id.cosmetics_discount);
            mName=itemView.findViewById(R.id.cosmetic_name);


        }

        @SuppressLint("CheckResult")
        public void bind(recycler_model data, RecyclerClick itemclicked){
            RequestOptions options=new RequestOptions();
            Log.d("DebugAbhi","executing bind function");
            options.placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_baseline_error_24);

            Glide.with(itemView.getContext())
                    .applyDefaultRequestOptions(options)
                    .asBitmap()
                    .load(data.getImgLink())
                    .into(proImage);
            Log.d("DebugAbhi",data.getImgLink());
            priceText.setText(data.getPrice());
            Discount.setText(data.getDiscount());
            mName.setText(data.getName());
            itemView.setOnClickListener(v -> itemclicked.itemClick(data,getAbsoluteAdapterPosition()));

        }
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_cosmetic_model,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.bind(items.get(position),click);



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}


