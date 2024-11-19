package com.brain.healthcareapp;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText Name,Password;
    Button Login;
    TextView Tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name=findViewById(R.id.userName);
        Password=findViewById(R.id.password);
        Tv=findViewById(R.id.register);
        Login=findViewById(R.id.login);


        Login.setOnClickListener(v -> {
            String username=Name.getText().toString();
            String password=Password.getText().toString();
            if(username.isEmpty() || password.isEmpty())
            {
                Toast.makeText(LoginActivity.this, "Fill ALl Details", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Login SuccessFul ",Toast.LENGTH_SHORT).show();
            }

        });

        Tv.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this,RegisterActivity.class)));

    }
}