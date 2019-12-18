package com.example.eatmeatproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Introdaction extends AppCompatActivity {
    public static int page = 1;
    TextView title, content;
    MaterialButton Next, skip;
    ImageView LoginRegesterImag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.longinorregester1);
        title = findViewById(R.id.TitleLoginOrRegister2);
        content = findViewById(R.id.ConLoginOrRegister2);
        Next = findViewById(R.id.text_Next);
        skip = findViewById(R.id.text_Skip);
        LoginRegesterImag = findViewById(R.id.LoginRegesterImage);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (page == 1) {
                    title.setText(R.string.TitleLoginOrRegister2);
                    content.setText(R.string.ConLoginOrRegister2);
                    LoginRegesterImag.setImageResource(R.drawable.loginandregesterscond);
                    page = 2;
                } else if (page == 2) {
                    Intent intent = new Intent(Introdaction.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Introdaction.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
