package com.example.eatmeatproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class NotificationAdapter extends FirestoreRecyclerAdapter<ModelNotification, NotificationAdapter.ImportentHolder1> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    ImageView  imageView11;
    TextView dis,namenot;
    public NotificationAdapter(@NonNull FirestoreRecyclerOptions<ModelNotification> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ImportentHolder1 holder, int position, @NonNull ModelNotification model) {
//        holder.bind(position,model);
        Glide.with(imageView11).load(model.getimage_url()).into(imageView11);
        dis.setText(model.getdis());
        namenot.setText(model.getName());

    }

    @NonNull
    @Override
    public ImportentHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.custum_list_notifications,parent,false);
        return new ImportentHolder1(v);
    }
    public void deleteItem(int position)
    {
        getSnapshots().getSnapshot(position).getReference().delete();

    }
    class ImportentHolder1 extends RecyclerView.ViewHolder

    {

        public ImportentHolder1(@NonNull View itemView) {
            super(itemView);
            imageView11=itemView.findViewById(R.id.image_notification);
            dis=itemView.findViewById(R.id.text_notification_body);
            namenot=itemView.findViewById(R.id.text_notification_header);
        }
//        public void bind(int position, ImportantDishes model)
//        {
//            Glide.with(imageView).load(model.getImag_uri()).into(imageView);
//        }
    }
}
