package com.example.eatmeatproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class RegisterOrLoginHere extends AppCompatActivity {
    MaterialButton login, sinup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_or_login_here);
//        login = findViewById(R.id.gotologin);
//        sinup = findViewById(R.id.gotosinup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterOrLoginHere.this, LogInActivity.class);
                startActivity(intent);
            }
        });
        sinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterOrLoginHere.this, CreateAcontActivity.class));
            }
        });

    }
}
