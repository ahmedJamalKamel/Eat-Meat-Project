package com.example.eatmeatproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SingUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_up_activity);
    }

    public void singIn(View view) {
        Intent intent = new Intent(SingUpActivity.this, LogInActivity.class);
        startActivity(intent);
    }
}
