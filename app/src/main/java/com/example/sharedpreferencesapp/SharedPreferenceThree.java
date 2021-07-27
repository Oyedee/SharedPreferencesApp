package com.example.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SharedPreferenceThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_three);

        SharedPreferences sharedPreferences = getSharedPreferences("DisplayValues", MODE_PRIVATE);

        TextView name = findViewById(R.id.text_name);
        TextView email = findViewById(R.id.text_email);
        TextView address = findViewById(R.id.text_address);

        Button button = findViewById(R.id.button_contact);

        name.setText(sharedPreferences.getString("NAME_VALUE", ""));
        email.setText(sharedPreferences.getString("EMAIL_VALUE", ""));
        address.setText(sharedPreferences.getString("ADDRESS_VALUE", ""));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("mailto: " + sharedPreferences.getString("EMAIL_VALUE", "")));
                startActivity(intent);
            }
        });
    }
}