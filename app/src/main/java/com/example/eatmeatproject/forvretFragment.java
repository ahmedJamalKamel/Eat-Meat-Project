package com.example.eatmeatproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class forvretFragment extends Fragment {
    RecyclerView favorite_recycler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorat_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        favorite_recycler = view.findViewById(R.id.favorite_recycler);
        favorite_recycler.addItemDecoration(new GridSpacingItemDecoration(2, 45, true));
        favorite_recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));

        FavoriteAdapter adapter = new FavoriteAdapter();
        favorite_recycler.setAdapter(adapter);
    }

    private class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
        @NonNull
        @Override
        public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item, parent, false);
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
