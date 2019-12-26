package com.example.eatmeatproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

public class TestDownlowedFromFierStore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_downlowed_from_fier_store);
        RecyclerView recyclerView=findViewById(R.id.RecyclerView11);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseStorage.getInstance().getReference().child("restaurants/taboon/candy/").listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                if (listResult != null)
                {
                    recyclerView.setAdapter(new PhotoAdapter(listResult.getItems()));
//                    for (StorageReference storageReference:listResult.getItems())
//                    {
//                        System.out.println("v "+storageReference.getName());
//
//                    }
                }
                else
                {

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("v jjjjjj");

            }
        });

    }
    }

