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

import com.example.dog_app.Model.Med;
import com.example.dog_app.R;

import java.util.List;

public class RecyclerViewAdapter_med extends RecyclerView.Adapter<RecyclerViewAdapter_med.MyViewHolder>{
    private Context context;
    private List<Med> smed;
    public RecyclerViewAdapter_med(Context context, List<Med> smed) {
        this.context =context;
        this.smed =smed;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view =mInflater.inflate(R.layout.small,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.variety.setText(smed.get(position).getVariety());
        holder.dog_img.setImageResource(smed.get(position).getImg());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(context,Med_thing.class);
                intent.putExtra("img",smed.get(position).getImg());
                intent.putExtra("variety",smed.get(position).getVariety());
                intent.putExtra("from",smed.get(position).getFrom());
                intent.putExtra("body",smed.get(position).getBody());
                intent.putExtra("high",smed.get(position).getHigh());
                intent.putExtra("hair",smed.get(position).getHair());
                intent.putExtra("color",smed.get(position).getColor());
                intent.putExtra("personality",smed.get(position).getPersonality());
                intent.putExtra("feature",smed.get(position).getFeature());
                intent.putExtra("history",smed.get(position).getHistory());
                intent.putExtra("support",smed.get(position).getSupport());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return smed.size();
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
