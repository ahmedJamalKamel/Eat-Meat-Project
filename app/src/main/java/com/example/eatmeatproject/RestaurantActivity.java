package com.example.eatmeatproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestaurantActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RestaurantAdapter adapter;
    List<Restaurant> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ProgressBar progressBar = findViewById(R.id.progress_bar);
        recyclerView=findViewById(R.id.restaurant_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference docRef = db.collection("TRestaurant");
        docRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("oooo",document.getId() + " => " + document.getData());
                        Gson gson = new Gson();
                        Restaurant restaurant = gson.fromJson(gson.toJson(document.getData()),Restaurant.class);
                        list.add(restaurant);
                    }
                    adapter= new RestaurantAdapter(RestaurantActivity.this, list, position -> {
                        startActivity(new Intent(RestaurantActivity.this,MenuActivity.class));
                    });
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.INVISIBLE);

                } else {

                    Log.d("oooo", "Error getting documents: ", task.getException());
                    progressBar.setVisibility(View.INVISIBLE);

                }

            }
        });


    }
}
