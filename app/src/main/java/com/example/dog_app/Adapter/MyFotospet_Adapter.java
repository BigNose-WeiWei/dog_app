package com.example.dog_app.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dog_app.Fragments.MypetDetailFragment;
import com.example.dog_app.Fragments.PostDetailFragment;
import com.example.dog_app.Model.Mypet;
import com.example.dog_app.R;

import java.util.List;

public class MyFotospet_Adapter extends RecyclerView.Adapter<MyFotospet_Adapter.ImageViewHolder> {

    private Context mContext;
    private List<Mypet> Mypets;

    public MyFotospet_Adapter(Context context, List<Mypet> mypets){
        mContext = context;
        Mypets = mypets;
    }

    @NonNull
    @Override
    public MyFotospet_Adapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fotos_pet_item, parent, false);
        return new MyFotospet_Adapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyFotospet_Adapter.ImageViewHolder holder, final int position) {

        final Mypet mypet = Mypets.get(position);

        Glide.with(mContext).load(mypet.getPostimage()).into(holder.pet_image);

        holder.pet_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mContext.getSharedPreferences("Mypet", Context.MODE_PRIVATE).edit();
                editor.putString("postid", mypet.getPostid());
                editor.apply();

                ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MypetDetailFragment()).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return Mypets.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {




        public ImageView pet_image;



        public ImageViewHolder(View itemView) {
            super(itemView);

            pet_image = itemView.findViewById(R.id.mypet_image);



        }
    }
}