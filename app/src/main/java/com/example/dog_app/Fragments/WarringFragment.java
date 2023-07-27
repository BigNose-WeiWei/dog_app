package com.example.dog_app.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dog_app.CommonActivity;
import com.example.dog_app.IntroduceActivity;
import com.example.dog_app.NofoodActivity;
import com.example.dog_app.R;
import com.example.dog_app.TrainingActivity;


public class WarringFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.warring, container, false);

        Button com = view.findViewById(R.id.common);
        Button food = view.findViewById(R.id.food);
        Button Introduce = view.findViewById(R.id.Introduce);
        Button training = view.findViewById(R.id.training);

        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CommonActivity.class);
                startActivity(intent);
            }

        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NofoodActivity.class);
                startActivity(intent);
            }

        });

        Introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), IntroduceActivity.class);
                startActivity(intent);
            }

        });

        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TrainingActivity.class);
                startActivity(intent);
            }

        });

        return view;
    }


}
