package com.example.dog_app.Introduce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dog_app.R;

public class Med_thing extends AppCompatActivity {

    private TextView name,form,high,personality,hair,body,talk,color,feature,history,support;
    private ImageView img,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_thing);
        support =findViewById(R.id.support_thing);
        history =findViewById(R.id.history_thing);
        feature =findViewById(R.id.feature_thing);
        personality =findViewById(R.id.personality_thing);
        color=findViewById(R.id.color_thing);
        hair=findViewById(R.id.hair_thing);
        high=findViewById(R.id.high_thing);
        body=findViewById(R.id.body_thing);
        form=findViewById(R.id.from_thing);
        name=findViewById(R.id.variety_thing);
        img=findViewById(R.id.imageView_thing);
        Intent intent = getIntent();
        int image = intent.getExtras().getInt("img");
        String name_= intent.getExtras().getString("variety");
        String from_= intent.getExtras().getString("from");
        String body_= intent.getExtras().getString("body");
        String hair_= intent.getExtras().getString("hair");
        String high_= intent.getExtras().getString("high");
        String color_= intent.getExtras().getString("color");
        String personality_= intent.getExtras().getString("personality");
        String feature_= intent.getExtras().getString("feature");
        String history_= intent.getExtras().getString("history");
        String support_= intent.getExtras().getString("support");
        img.setImageResource(image);
        name.setText(name_);
        form.setText(from_);
        body.setText(body_);
        hair.setText(hair_);
        high.setText(high_);
        color.setText(color_);
        personality.setText(personality_);
        feature.setText(feature_);
        history.setText(history_);
        support.setText(support_);
    }
}
