package com.example.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    checkBox.setText("This CheckBox is checked");
                } else {
                    checkBox.setText("This CheckBox is not checked");
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("TEXT_VALUE", checkBox.getText().toString());
        editor.putBoolean("CHECKBOX_VALUE", checkBox.isChecked());
        editor.apply();

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        String text = sharedPreferences.getString("TEXT_VALUE", "");
        Boolean check = sharedPreferences.getBoolean("CHECKBOX_CHECKED", false);
        checkBox.setText(text);
        checkBox.setChecked(check);

    }
}