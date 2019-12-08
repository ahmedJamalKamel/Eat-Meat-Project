package com.example.eatmeatproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterOrLoginHere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_or_login_here);
    }

    public void logIn(View view) {
        Intent intent = new Intent(RegisterOrLoginHere.this, LogInActivity.class);
        startActivity(intent);
    }

    public void singUp(View view) {
        setContentView(R.layout.chose_create_accont);
    }

    public void CreateAccount(View view) {
        Intent intent = new Intent(RegisterOrLoginHere.this, SingUpActivity.class);
        startActivity(intent);
    }
}
