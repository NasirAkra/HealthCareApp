package com.brain.healthcareapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences=getSharedPreferences("shared-prefs", Context.MODE_PRIVATE);
        String username= sharedPreferences.getString("username", "");
        Toast.makeText(this, "Welcome"+username, Toast.LENGTH_SHORT).show();
        CardView exit =findViewById(R.id.cardExit);
        exit.setOnClickListener(v -> {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));

        });

        CardView findDoctor =findViewById(R.id.cardFindDoctor);

        findDoctor.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this,FindDoctorActivity.class)));


    }
}