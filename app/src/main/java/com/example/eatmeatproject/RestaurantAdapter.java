package com.example.eatmeatproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RestaurantAdapter extends
        RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private static final String TAG = RestaurantAdapter.class.getSimpleName();

    private Context context;
    private List<Restaurant> list;
    private OnItemClickListener onItemClickListener;

    public RestaurantAdapter(Context context, List<Restaurant> list,
                             OnItemClickListener onItemClickListener) {
        this.context = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView res_image;
        TextView res_name;
        TextView res_description;

        public ViewHolder(View itemView) {
            super(itemView);


            res_image=itemView.findViewById(R.id.imageView3);
            res_name = itemView.findViewById(R.id.name_dishes);
            res_description=itemView.findViewById(R.id.textView6);
        }

        public void bind(final Restaurant model,
                         final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getLayoutPosition());

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.restaurant_item, parent, false);


        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurant item = list.get(position);

        Glide.with(context).load(item.getImage_url()).into(holder.res_image);
        holder.res_name.setText(item.getName());
        holder.res_description.setText(item.getDesc());
        holder.bind(item, onItemClickListener);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}