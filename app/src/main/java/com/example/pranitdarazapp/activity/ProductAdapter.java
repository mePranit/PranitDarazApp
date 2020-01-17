package com.example.pranitdarazapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pranitdarazapp.Retrofit.dbconnect;
import com.example.pranitdarazapp.R;
import com.example.pranitdarazapp.modal.Products;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{

    Context context;
    List<Products> ProductsGet;

    public ProductAdapter(Context context, List<Products> productModals) {
        this.context = context;
        this.ProductsGet = productModals;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_product,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Products productModal = ProductsGet.get(position);
        holder.txt_item_product_name.setText(productModal.get_productName());
        holder.txt_item_product_price.setText(productModal.get_productPrice());
        Picasso.get().load(dbconnect.image_url+ ProductsGet.get(position).get_productImage()).into(holder.item_product_image);
    }

    @Override
    public int getItemCount() {
        return ProductsGet.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_item_product_name,txt_item_product_price;
        ImageView item_product_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_item_product_name = itemView.findViewById(R.id.txtProductName);
            txt_item_product_price = itemView.findViewById(R.id.txtPrice);
            item_product_image = itemView.findViewById(R.id.imgProduct);
        }
    }

    public static class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }
}