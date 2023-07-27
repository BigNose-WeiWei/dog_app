package com.example.dog_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dog_app.Training.Training_attitude;
import com.example.dog_app.Training.Training_cage;
import com.example.dog_app.Training.Training_fight;
import com.example.dog_app.Training.Training_language;
import com.example.dog_app.Training.Training_leash;
import com.example.dog_app.Training.Training_toys;
import com.example.dog_app.Training.Training_training;

public class TrainingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
    }
    public void train(View view){
        Intent intent = new Intent(TrainingActivity.this, Training_training.class);
        startActivity(intent);
    }
    public void attitude(View view){
        Intent intent = new Intent(TrainingActivity.this, Training_attitude.class);
        startActivity(intent);
    }
    public void leash(View view){
        Intent intent = new Intent(TrainingActivity.this, Training_leash.class);
        startActivity(intent);
    }
    public void cage(View view){
        Intent intent = new Intent(TrainingActivity.this, Training_cage.class);
        startActivity(intent);
    }
    public void toys(View view){
        Intent intent = new Intent(TrainingActivity.this, Training_toys.class);
        startActivity(intent);
    }
    public void fight(View view){
        Intent intent = new Intent(TrainingActivity.this, Training_fight.class);
        startActivity(intent);
    }
    public void language(View view){
        Intent intent = new Intent(TrainingActivity.this, Training_language.class);
        startActivity(intent);
    }
}
