package com.brain.healthcareapp;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText Rename,Repassword,Reconfirmpassword,Email;
    Button Register;
    TextView AlreadyAccount;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Rename=findViewById(R.id.ReuserName);
        Repassword=findViewById(R.id.Repassword);
        Email=findViewById(R.id.email);
        Reconfirmpassword=findViewById(R.id.confirmpassword);
        Register=findViewById(R.id.Register);
        AlreadyAccount=findViewById(R.id.ExitUser);

        AlreadyAccount.setOnClickListener(v -> startActivity(new Intent(RegisterActivity.this,LoginActivity.class)));
        Register.setOnClickListener(v -> {
            String username=Rename.getText().toString();
            String password=Repassword.getText().toString();
            String Confirm=Reconfirmpassword.getText().toString();
            String email=Email.getText().toString();
            Database db =new Database(getApplicationContext(),"HealthCare",null,1);

            if (username.isEmpty() || password.isEmpty() || Confirm.isEmpty() || email.isEmpty())
            {
                Toast.makeText(RegisterActivity.this, "Fill All The Details", Toast.LENGTH_SHORT).show();
            }
            else
            {
               if (password.compareTo(Confirm)==0)
               {
                   if (isValid(password))
                   {
                       db.register(username,email,password);
                       Toast.makeText(this, "Record Inserted", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                       
                   }
                   else {
                       Toast.makeText(this, "Password must contain at least 8 characters ,having letters, and digits , spacial symbols ", Toast.LENGTH_SHORT).show();
                   }

               }
               else {
                   Toast.makeText(this, "Password and confirm password don't match", Toast.LENGTH_SHORT).show();
               }
            }
        });

    }
    public static boolean isValid(String passwordhere)

    {
        int f1=0,f2=0,f3=0;
        if (passwordhere.length()<8)
        {
            return false;
        }
        else {
            for (int p=0; p<passwordhere.length(); p++)
            {
                if (Character.isDigit(passwordhere.charAt(p)))
                {
                    f1=1;
                }
            }
            for (int r=0; r<passwordhere.length(); r++)
            {
                if (Character.isDigit(passwordhere.charAt(r)))
                {
                    f2=1;
                }
            }
            for (int s=0; s<passwordhere.length(); s++)
            {
                if (Character.isDigit(passwordhere.charAt(s)))
                {
                    f3=1;
                }
            }

            return f1 == 1 && f2 == 1 && f3 == 1;
        }

    }
}