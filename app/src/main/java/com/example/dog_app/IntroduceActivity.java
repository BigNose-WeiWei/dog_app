package com.example.dog_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dog_app.Introduce.Introduce_big;
import com.example.dog_app.Introduce.Introduce_medium;
import com.example.dog_app.Introduce.Introduce_small;
import com.example.dog_app.Introduce.Introduce_vbig;

public class IntroduceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
    }

    public void small(View view){
        Intent intent = new Intent(IntroduceActivity.this, Introduce_small.class);
        startActivity(intent);
    }
    public void medium(View view){
        Intent intent = new Intent(IntroduceActivity.this, Introduce_medium.class);
        startActivity(intent);
    }
    public void big(View view){
        Intent intent = new Intent(IntroduceActivity.this, Introduce_big.class);
        startActivity(intent);
    }
    public void big_special(View view){
        Intent intent = new Intent(IntroduceActivity.this, Introduce_vbig.class);
        startActivity(intent);
    }
}
