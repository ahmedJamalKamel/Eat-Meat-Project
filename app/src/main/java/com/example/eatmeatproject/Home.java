package com.example.eatmeatproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    RecyclerView category_recycler,dishes_recycler,restaurant_recycler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        AutoScrollPagerAdapter autoScrollPagerAdapter =
                new AutoScrollPagerAdapter(getSupportFragmentManager());
        AutoScrollViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(autoScrollPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        // start auto scroll
        viewPager.startAutoScroll();
        // set auto scroll time in mili
        viewPager.setInterval(4000);
        // enable recycling using true
        viewPager.setCycle(true);

        ArrayList<Integer> categories = new ArrayList<>();
        categories.add(R.drawable.burger);
        categories.add(R.drawable.pizza);
        categories.add(R.drawable.breakfast);
        categories.add(R.drawable.juice);
        categories.add(R.drawable.ice_cream);
        categories.add(R.drawable.burger);
        categories.add(R.drawable.pizza);

        category_recycler=findViewById(R.id.category_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        category_recycler.setLayoutManager(linearLayoutManager);
        CategoryAdapter adapter = new CategoryAdapter(this,categories);
        category_recycler.setAdapter(adapter);

        dishes_recycler=findViewById(R.id.dishes_recycler);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        dishes_recycler.setLayoutManager(linearLayoutManager2);
        DishesAdapter adapter2 = new DishesAdapter();
        dishes_recycler.setAdapter(adapter2);

        restaurant_recycler=findViewById(R.id.restaurant_recycler);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        restaurant_recycler.setLayoutManager(linearLayoutManager3);
        RestaurantsAdapter adapter3 = new RestaurantsAdapter();
        restaurant_recycler.setAdapter(adapter3);

    }


    private class CategoryAdapter extends  RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
        ArrayList<Integer> categories;
        Context context;

        public CategoryAdapter(Context context,ArrayList<Integer> categories) {
            this.categories=categories;
            this.context=context;
        }

        @NonNull
        @Override
        public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
            return new CategoryAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
            Glide.with(context).load(categories.get(position)).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return categories.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.category_image);
            }
        }
    }

    private class DishesAdapter extends  RecyclerView.Adapter<DishesAdapter.ViewHolder> {
        @NonNull
        @Override
        public DishesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.important_dishes_item,parent,false);
            return new DishesAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DishesAdapter.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {

                super(itemView);
            }
        }
    }

    private class RestaurantsAdapter extends  RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>{
        @NonNull
        @Override
        public RestaurantsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.important_restaurant_item,parent,false);
            return new RestaurantsAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RestaurantsAdapter.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {

                super(itemView);
            }
        }
    }
}
