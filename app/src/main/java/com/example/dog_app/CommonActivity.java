package com.example.dog_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dog_app.Common.Common_friend;
import com.example.dog_app.Common.Common_puppies;
import com.example.dog_app.Common.Common_responsibility;
import com.example.dog_app.Common.Common_sense_condition;

public class CommonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView imgAlarm,imgAlarm_2,imgAlarm_3,imgAlarm_4;
        TextView common_sense_condition,puppies,friend,responsibility;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        imgAlarm = (ImageView) findViewById(R.id.imageButton);
        imgAlarm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommonActivity.this, Common_sense_condition.class);
                startActivity(intent);
            }
        });

        common_sense_condition = (TextView) findViewById(R.id.textView20);
        common_sense_condition.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommonActivity.this, Common_sense_condition.class);
                startActivity(intent);
            }
        });

        imgAlarm_2 = (ImageView) findViewById(R.id.imageButton2);
        imgAlarm_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommonActivity.this, Common_puppies.class);
                startActivity(intent);
            }
        });

        common_sense_condition = (TextView) findViewById(R.id.textView21);
        common_sense_condition.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommonActivity.this, Common_puppies.class);
                startActivity(intent);
            }
        });

        imgAlarm_3= (ImageView) findViewById(R.id.imageButton3);
        imgAlarm_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommonActivity.this, Common_friend.class);
                startActivity(intent);
            }
        });

        common_sense_condition = (TextView) findViewById(R.id.textView22);
        common_sense_condition.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommonActivity.this, Common_friend.class);
                startActivity(intent);
            }
        });

        imgAlarm_4 = (ImageView) findViewById(R.id.imageButton5);
        imgAlarm_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommonActivity.this, Common_responsibility.class);
                startActivity(intent);
            }
        });

        common_sense_condition = (TextView) findViewById(R.id.textView23);
        common_sense_condition.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommonActivity.this, Common_responsibility.class);
                startActivity(intent);
            }
        });






    }
}
