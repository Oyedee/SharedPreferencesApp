package com.example.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SharedPreferenceTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_two);

        SharedPreferences sharedPreferences = getSharedPreferences("DisplayValues", MODE_PRIVATE);

        if (sharedPreferences.contains("VALID")) {
            startActivity( new Intent(SharedPreferenceTwo.this, SharedPreferenceThree.class));
        }


        EditText name = findViewById(R.id.edit_text);
        EditText email = findViewById(R.id.edit_text2);
        EditText address = findViewById(R.id.edit_text3);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("DisplayValues", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NAME_VALUE", name.getText().toString());
                editor.putString("EMAIL_VALUE", email.getText().toString());
                editor.putString("ADDRESS_VALUE", address.getText().toString());
                editor.putBoolean("VALID", true);
                editor.apply();

                Intent intent = new Intent(SharedPreferenceTwo.this, SharedPreferenceThree.class);
                startActivity(intent);
            }
        });
    }
}