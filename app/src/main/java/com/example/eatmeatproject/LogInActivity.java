package com.example.eatmeatproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_in);
    }

    public void forgetPass(View view) {
        Intent intent = new Intent(LogInActivity.this, forgetPass.class);
        startActivity(intent);
    }

    public void singintohome(View view) {
        Intent intent = new Intent(LogInActivity.this, Home.class);
        startActivity(intent);
    }
}
