package com.example.eatmeatproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        ProgressBar progress = findViewById(R.id.progress);
        Toolbar toolbar = findViewById(R.id.toolbar);
        List<String> tabs_name=new ArrayList<>();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference docRef = db.collection("TMenu").document("N3KFMivaAa06grq5yEYw").collection("candy");
        Log.v("ssss",docRef.getId());

        docRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        Log.v("ssss",queryDocumentSnapshots.size()+"");

//                        Gson gson = new Gson();
//                        Restaurant restaurant = gson.fromJson(gson.toJson(document.getData()),Restaurant.class);


                    progress.setVisibility(View.INVISIBLE);

            }
        });
//        OnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//
//                if (task.isSuccessful()) {
//                    Log.d("ssss",task.getResult()+"");
//                    docRef.collection("candy").document("2n64kzG9Z9QFwblH32G9").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                        @Override
//                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                            if (task.isSuccessful()){
//                                Log.v("qwqw",task.getResult().getString("name")+"");
//                            }
//                        }
//                    });
//                }
//            }
//        });


        TabLayout tabLayout=findViewById(R.id.tabs);
        ViewPager viewPager=findViewById(R.id.view_pager_for_resturant);
        viewPager.setAdapter(new ViewPagerAdapterRes(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);


    }
    public class ViewPagerAdapterRes extends FragmentPagerAdapter {

        public ViewPagerAdapterRes(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new RestorentFragment();
                case 1:
                    return new RestorentFragment();
                case 2:
                    return new RestorentFragment();
                case 3:
                    return new RestorentFragment();
                case 4:
                    return new RestorentFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.Main_Dishes);
                case 1:
                    return getString(R.string.Entrees);
                case 2:
                    return getString(R.string.Sandwiches);
                case 3:
                    return getString(R.string.Candy);
                case 4:
                    return getString(R.string.Meals);
            }
            return null;
        }
    }
}
