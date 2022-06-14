package com.aprendiendo.android.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aprendiendo.android.ConfirmPurchase;
import com.aprendiendo.android.Inicio;
import com.aprendiendo.android.Models.Product;
import com.aprendiendo.android.R;
import com.aprendiendo.android.databinding.CardItemBinding;
import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Handler;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>
{

    private Context where;
    CardItemBinding cardItemBinding;
    private ArrayList<Product> productArray;

    public ProductAdapter(Context where, ArrayList<Product> productArray)
    {
        this.where = where;
        this.productArray = productArray;

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        cardItemBinding = CardItemBinding.inflate(LayoutInflater.from(where));
        return new ProductViewHolder(cardItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
            Product product = productArray.get(position);
            holder.itemBinding.tvrating.setText(product.getRating()+",0");
            holder.itemBinding.tvName.setText(product.getName());
            Integer precio = product.getPrice();
            holder.itemBinding.tvPrice.setText(precio.toString());
            holder.itemBinding.tvCategory.setText(" · "+product.getCategory()+" · 1km");
            Glide.with(where).load(product.getImg_url()).into(holder.itemBinding.ivPicture);
            Glide.with(where).load(R.mipmap.star).into(holder.itemBinding.ivStar1);
            // si clickean un producto
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Toast.makeText(where,""+product.getName(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(where, ConfirmPurchase.class);
                    intent.putExtra("image",product.getImg_url());
                    intent.putExtra("name",product.getName());
                    intent.putExtra("price",precio);
                    intent.putExtra("id",product.getId());
                    where.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return productArray.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        CardItemBinding itemBinding;
        public ProductViewHolder(@NonNull CardItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }



}

