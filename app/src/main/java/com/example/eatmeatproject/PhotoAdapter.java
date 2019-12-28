package com.example.eatmeatproject;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotosHolder> {

    private List<StorageReference> mItem;

    public PhotoAdapter(List<StorageReference> item) {
        this.mItem = item;
    }

    @NonNull
    @Override
    public PhotosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custum_list_resternt, parent, false);
        return new PhotosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    class PhotosHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        //private TextView textView;
        public PhotosHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_notification);
            //textView=itemView.findViewById(R.id.textViewFielName);

        }

        public void bind(int position) {
            // textView.setText(mItem.get(position).getName());
            mItem.get(position).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {

                    System.out.println("name " + uri);

//                    Glide.with(imageView).load(uri).into(imageView);
                    // imageView.setImageURI(uri);
                }
            });
        }

    }
}
