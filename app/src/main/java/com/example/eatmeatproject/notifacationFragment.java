package com.example.eatmeatproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class notifacationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notification_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        List<PhotoAndTextNotidication> images = new ArrayList<>();
        images.add(new PhotoAndTextNotidication("Photo 1", R.drawable.image_notification));
        images.add(new PhotoAndTextNotidication("Photo 2", R.drawable.image_notification));
        images.add(new PhotoAndTextNotidication("Photo 3", R.drawable.image_notification));
        images.add(new PhotoAndTextNotidication("Photo 4", R.drawable.image_notification));
        images.add(new PhotoAndTextNotidication("Photo 5", R.drawable.image_notification));
        images.add(new PhotoAndTextNotidication("Photo 6", R.drawable.image_notification));
        images.add(new PhotoAndTextNotidication("Photo 7", R.drawable.image_notification));
        images.add(new PhotoAndTextNotidication("Photo 8", R.drawable.image_notification));
        ListView listView = view.findViewById(R.id.list_view);
        PhotosAdapter arrayAdapter = new PhotosAdapter(images);
        listView.setAdapter(arrayAdapter);
    }

    class PhotosAdapter extends BaseAdapter {
        List<PhotoAndTextNotidication> items;

        public PhotosAdapter(List<PhotoAndTextNotidication> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Nullable
        @Override
        public PhotoAndTextNotidication getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.custum_list_notifications, parent, false);
                holder = new ViewHolder();
                holder.photoTitleTextView = convertView.findViewById(R.id.text_notification_body);
                holder.photoImageView = convertView.findViewById(R.id.image_notification);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();

            }
            PhotoAndTextNotidication photo = getItem(position);
            holder.photoTitleTextView.setText(photo.getPotoTitle());
            holder.photoImageView.setImageResource(photo.getImageResoursId());
            return convertView;
        }

        class ViewHolder {
            TextView photoTitleTextView;
            ImageView photoImageView;
        }
    }

}
