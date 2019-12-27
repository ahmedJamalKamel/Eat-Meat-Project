package com.example.eatmeatproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView category_recycler, dishes_recycler, restaurant_recycler;
    private CollectionReference collectionReference;
    private CollectionReference collectionReferenceRestornt;
    private ImprtantDishesAdapter adapter;
    private ImprtantRestaurantAdapter adapterrestorent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        collectionReference = db.collection("TImportantDishes");
        collectionReferenceRestornt = db.collection("TRestaurant");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_activity2_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Query query = collectionReference.orderBy("name");
        FirestoreRecyclerOptions<ImportantDishes> options = new FirestoreRecyclerOptions
                .Builder<ImportantDishes>()
                .setQuery(query, ImportantDishes.class)
                .build();

        adapter = new ImprtantDishesAdapter(options);
        RecyclerView recyclerView = view.findViewById(R.id.dishes_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        ///////////////////////////

        Query queryRestorent = collectionReferenceRestornt.orderBy("name");
        FirestoreRecyclerOptions<ModelImprtantRestaurant> optionsRestorent = new FirestoreRecyclerOptions
                .Builder<ModelImprtantRestaurant>()
                .setQuery(queryRestorent, ModelImprtantRestaurant.class)
                .build();

        adapterrestorent = new ImprtantRestaurantAdapter(optionsRestorent);
        RecyclerView recyclerViewRestorent = view.findViewById(R.id.restaurant_recycler);
        recyclerViewRestorent.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerViewRestorent.setAdapter(adapterrestorent);

        ///////////////////////////

        AutoScrollPagerAdapter autoScrollPagerAdapter =
                new AutoScrollPagerAdapter(getFragmentManager());
        AutoScrollViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(autoScrollPagerAdapter);
        TabLayout tabs = view.findViewById(R.id.tabs);
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

        category_recycler = view.findViewById(R.id.category_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        category_recycler.setLayoutManager(linearLayoutManager);
        CategoryAdapter adapter = new CategoryAdapter(getContext(), categories);
        category_recycler.setAdapter(adapter);

//        dishes_recycler = view.findViewById(R.id.dishes_recycler);
//        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
//        dishes_recycler.setLayoutManager(linearLayoutManager2);
//        DishesAdapter adapter2 = new DishesAdapter();
//        dishes_recycler.setAdapter(adapter2);

//        restaurant_recycler = view.findViewById(R.id.restaurant_recycler);
//        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        restaurant_recycler.setLayoutManager(linearLayoutManager3);
//        RestaurantsAdapter adapter3 = new RestaurantsAdapter();
//        restaurant_recycler.setAdapter(adapter3);
    }

    @Override
    public void onStart() {
        super.onStart();
        adapterrestorent.startListening();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapterrestorent.stopListening();
        adapter.stopListening();
    }

    private class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
        ArrayList<Integer> categories;
        Context context;

        public CategoryAdapter(Context context, ArrayList<Integer> categories) {
            this.categories = categories;
            this.context = context;
        }

        @NonNull
        @Override
        public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
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
                imageView = itemView.findViewById(R.id.category_image);
            }
        }
    }

    private class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.ViewHolder> {
        @NonNull
        @Override
        public DishesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.important_dishes_item, parent, false);
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

    private class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.ViewHolder> {
        @NonNull
        @Override
        public RestaurantsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.important_restaurant_item, parent, false);
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
