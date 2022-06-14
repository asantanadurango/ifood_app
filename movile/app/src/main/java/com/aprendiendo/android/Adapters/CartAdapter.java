package com.aprendiendo.android.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aprendiendo.android.Cart;
import com.aprendiendo.android.Inicio;
import com.aprendiendo.android.Models.CartItemModel;
import com.aprendiendo.android.Services.DeleteCartItem;
import com.aprendiendo.android.Services.GetAllCartItems;
import com.aprendiendo.android.Services.GetAllProducts;
import com.aprendiendo.android.databinding.CartItemBinding;
import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.aprendiendo.android.Services.ipConfig.ip;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>
{
     Context where;
    CartItemBinding cartBinding;
    private ArrayList<CartItemModel> cartItems;
    Retrofit retrofit;
    Context context;

    public CartAdapter(Context where, ArrayList<CartItemModel> cartItems)
    {
        this.where = where;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        cartBinding = CartItemBinding.inflate(LayoutInflater.from(where));
        return new CartViewHolder(cartBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {

        CartItemModel producto = cartItems.get(position);
        Glide.with(where).load(producto.getImg_url()).into(holder.cartBinding.ivImageCart);
        holder.cartBinding.tvNameCart.setText(producto.getName());
        holder.cartBinding.tvCant.setText("cant: "+producto.getCant());
        holder.cartBinding.tvPrice1.setText("precio: "+producto.getPrice());
        holder.cartBinding.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();
                DeleteCartItem service = retrofit.create(DeleteCartItem.class);
                Call<JsonObject> cosa = service.DeleteCartItem(producto.getId());
                cosa.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        JsonObject objeto = response.body();

                        String s = "Se ha eliminado de tu carrito";
                        Toast.makeText(where,s,Toast.LENGTH_SHORT).show();
                        cartItems.remove(producto);
                        notifyDataSetChanged();

                        GetAllCartItems service = retrofit.create(GetAllCartItems.class);
                        Call<ArrayList<CartItemModel>> array = service.GetCart();
                        array.enqueue(new Callback<ArrayList<CartItemModel>>() {
                            @Override
                            public void onResponse(Call<ArrayList<CartItemModel>> call, Response<ArrayList<CartItemModel>> response) {
                               if(response.body().size()==0)
                               {
                                   Intent intent = new Intent(where,Cart.class);
                                   where.startActivity(intent);


                               }
                            }

                            @Override
                            public void onFailure(Call<ArrayList<CartItemModel>> call, Throwable t) {

                            }
                        });


                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(where,"problema conectando con base de datos"+t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
            CartItemBinding cartBinding;
        public CartViewHolder(@NonNull CartItemBinding cartBinding) {
            super(cartBinding.getRoot());
            this.cartBinding = cartBinding;

        }
    }
}
