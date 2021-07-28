package com.example.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SharedPreferenceFour extends AppCompatActivity {

    TextView name;
    SharedPreferences sharedPreferences;
    int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_four);

        name = findViewById(R.id.times_count);
        sharedPreferences = getSharedPreferences("NUMBER_OF_TIMES", MODE_PRIVATE);

        if(sharedPreferences.contains("NUMBER")) {
            time = sharedPreferences.getInt("NUMBER", 0);
            time ++;
            name.setText("You have opened this app " + time + " times");
        } else {
            name.setText("You have opened this app " + time + " times");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("NUMBER", time);
        editor.apply();

    }
}