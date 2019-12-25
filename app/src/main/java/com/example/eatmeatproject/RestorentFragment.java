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

public class RestorentFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.restorent_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        List<PhotoAndTextRestorent> images = new ArrayList<>();
        images.add(new PhotoAndTextRestorent("RS 20$", R.drawable.burger_for_restorent));
        images.add(new PhotoAndTextRestorent("RS 20$", R.drawable.burger_for_restorent));
        images.add(new PhotoAndTextRestorent("RS 20$", R.drawable.burger_for_restorent));
        images.add(new PhotoAndTextRestorent("RS 20$", R.drawable.burger_for_restorent));
        images.add(new PhotoAndTextRestorent("RS 20$", R.drawable.burger_for_restorent));
        images.add(new PhotoAndTextRestorent("RS 20$", R.drawable.burger_for_restorent));
        images.add(new PhotoAndTextRestorent("RS 20$", R.drawable.burger_for_restorent));
        images.add(new PhotoAndTextRestorent("RS 20$", R.drawable.burger_for_restorent));
        ListView listView = view.findViewById(R.id.list_view_for_restorent);
        PhotosAdapter arrayAdapter = new PhotosAdapter(images);
        listView.setAdapter(arrayAdapter);
    }

    class PhotosAdapter extends BaseAdapter {
        List<PhotoAndTextRestorent> items;

        public PhotosAdapter(List<PhotoAndTextRestorent> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Nullable
        @Override
        public PhotoAndTextRestorent getItem(int position) {
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
            PhotoAndTextRestorent photo = getItem(position);
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
