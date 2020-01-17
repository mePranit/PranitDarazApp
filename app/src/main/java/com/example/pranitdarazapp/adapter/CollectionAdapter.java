package com.example.pranitdarazapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pranitdarazapp.Retrofit.dbconnect;
import com.example.pranitdarazapp.R;
import com.example.pranitdarazapp.modal.Collection;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.MyViewHolder>{

    Context context;
    List<Collection> CollectionGet;

    public CollectionAdapter(Context context, List<Collection> collectionModals) {
        this.context = context;
        this.CollectionGet = collectionModals;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_collection,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Collection collectionModal = CollectionGet.get(position);
        holder.txt_item_collection_title.setText(collectionModal.get_title());
        holder.txt_item_collection_des.setText(collectionModal.get_intro());
        Picasso.get().load(dbconnect.image_url+ CollectionGet.get(position).getImage()).into(holder.item_collection_image);
    }

    @Override
    public int getItemCount() {
        return CollectionGet.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt_item_collection_title,txt_item_collection_des;
        ImageView item_collection_image, item_background_image;
        public MyViewHolder(View itemView) {
            super(itemView);
            txt_item_collection_title = itemView.findViewById(R.id.collectionTitle);
            txt_item_collection_des = itemView.findViewById(R.id.collectionDes);
            item_collection_image = itemView.findViewById(R.id.collectionImage);
            item_background_image = itemView.findViewById(R.id.background_collection);
        }
    }
}