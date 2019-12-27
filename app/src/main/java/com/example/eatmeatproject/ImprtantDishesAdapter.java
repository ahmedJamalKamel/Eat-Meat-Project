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

public class ImprtantDishesAdapter extends FirestoreRecyclerAdapter<ImportantDishes,ImprtantDishesAdapter.ImportentHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    ImageView  imageView;
    TextView TimeDishes,NameDishes;
    public ImprtantDishesAdapter(@NonNull FirestoreRecyclerOptions<ImportantDishes> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ImportentHolder holder, int position, @NonNull ImportantDishes model) {
//        holder.bind(position,model);
        Glide.with(imageView).load(model.getimage_url()).into(imageView);
        TimeDishes.setText(model.getTime());
        NameDishes.setText(model.getName());

    }

    @NonNull
    @Override
    public ImportentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.important_dishes_item,parent,false);
        return new ImportentHolder(v);
    }
    public void deleteItem(int position)
    {
        getSnapshots().getSnapshot(position).getReference().delete();

    }
    class ImportentHolder extends RecyclerView.ViewHolder

    {

        public ImportentHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView3);
            TimeDishes=itemView.findViewById(R.id.time_dishes);
            NameDishes=itemView.findViewById(R.id.name_dishes);
        }
//        public void bind(int position, ImportantDishes model)
//        {
//            Glide.with(imageView).load(model.getImag_uri()).into(imageView);
//        }
    }
}
