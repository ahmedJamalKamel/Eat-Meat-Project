package com.example.eatmeatproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Favorites extends AppCompatActivity {
    RecyclerView favorite_recycler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);

        favorite_recycler=findViewById(R.id.favorite_recycler);

        favorite_recycler.addItemDecoration(new GridSpacingItemDecoration(2, 45, true));
        favorite_recycler.setLayoutManager(new GridLayoutManager(this,2));

        FavoriteAdapter adapter = new FavoriteAdapter ();
        favorite_recycler.setAdapter(adapter);

    }

    private class FavoriteAdapter extends  RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
        @NonNull
        @Override
        public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item,parent,false);
            return new FavoriteAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 8;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {

                super(itemView);
            }
        }
    }
}
