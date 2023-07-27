package com.example.dog_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.dog_app.Adapter.MyFotospet_Adapter;
import com.example.dog_app.Model.Post;

import java.util.List;

public class MypetActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypet);

        Intent intent = new Intent(MypetActivity.this, NewpetActivity.class);
        startActivity(intent);



    }


}
