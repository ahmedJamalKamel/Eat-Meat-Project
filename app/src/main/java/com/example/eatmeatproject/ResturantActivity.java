package com.example.eatmeatproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ResturantActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resturant_layout);
        System.out.println("v jjjjjj");

        Log.v("ss","asxasx");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResturantActivity.this, MainActivity.class));
            }
        });
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
