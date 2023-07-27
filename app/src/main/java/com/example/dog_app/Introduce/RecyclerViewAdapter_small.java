package com.example.dog_app.Introduce;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dog_app.Model.Small;
import com.example.dog_app.R;

import java.util.List;

public class RecyclerViewAdapter_small extends RecyclerView.Adapter<RecyclerViewAdapter_small.MyViewHolder>{
    private Context context;
    private List<Small> msmall;
    public RecyclerViewAdapter_small(Context context, List<Small> msmall) {
        this.context =context;
        this.msmall =msmall;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater =LayoutInflater.from(context);
        view =mInflater.inflate(R.layout.small,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.variety.setText(msmall.get(position).getVariety());
        holder.dog_img.setImageResource(msmall.get(position).getImg());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(context,Small_thing.class);
                intent.putExtra("img",msmall.get(position).getImg());
                intent.putExtra("img2",msmall.get(position).getImg2());
                intent.putExtra("variety",msmall.get(position).getVariety());
                intent.putExtra("from",msmall.get(position).getFrom());
                intent.putExtra("body",msmall.get(position).getBody());
                intent.putExtra("high",msmall.get(position).getHigh());
                intent.putExtra("hair",msmall.get(position).getHair());
                intent.putExtra("color",msmall.get(position).getColor());
                intent.putExtra("personality",msmall.get(position).getPersonality());
                intent.putExtra("feature",msmall.get(position).getFeature());
                intent.putExtra("history",msmall.get(position).getHistory());
                intent.putExtra("support",msmall.get(position).getSupport());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return msmall.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView dog_img;
        TextView variety;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            variety=itemView.findViewById(R.id.dog_name);
            dog_img=itemView.findViewById(R.id.dog_img);
            cardView=itemView.findViewById(R.id.cardview_id);
        }
    }
}
