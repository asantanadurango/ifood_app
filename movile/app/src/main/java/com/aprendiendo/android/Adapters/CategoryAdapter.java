package com.aprendiendo.android.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aprendiendo.android.Inicio;
import com.aprendiendo.android.Models.CategoryModel;
import com.aprendiendo.android.Models.Product;
import com.aprendiendo.android.R;
import com.aprendiendo.android.Services.GetAllProducts;
import com.aprendiendo.android.databinding.CartItemBinding;
import com.aprendiendo.android.databinding.CategoryItemBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.aprendiendo.android.Services.ipConfig.ip;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    Retrofit retrofit;
    ArrayList<CategoryModel> categoryModels;
    Context where;
    CategoryItemBinding categoryBinding;
    ArrayList<Product> productosFiltrados;


    public CategoryAdapter(Context where,ArrayList<CategoryModel> categoryModels)
    {
            this.where = where;
            this.categoryModels = categoryModels;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        categoryBinding = CategoryItemBinding.inflate(LayoutInflater.from(where));
        return new ViewHolder(categoryBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.categoryBinding.ivCategory.setImageResource(categoryModels.get(position).getCategoryLogo());
        holder.categoryBinding.tvCategoryNames.setText(categoryModels.get(position).getCategoryName());

        //TODO EL CODIGO PARA FILTRAR PRODUCTOS DESDE LA API ACA
        holder.categoryBinding.llCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();
                GetAllProducts service = retrofit.create(GetAllProducts.class);
                Call<ArrayList<Product>> myProducts = service.GetProducts(categoryModels.get(position).getCategoryName());
                myProducts.enqueue(new Callback<ArrayList<Product>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                        if(!response.isSuccessful())
                        {
                            Toast.makeText(where,"error no se recibio una respuesta de la api",Toast.LENGTH_SHORT).show();
                        }else{
                            productosFiltrados = response.body();
                            Toast.makeText(where,"el primer producto de la lista es"+productosFiltrados.get(0).getName(),Toast.LENGTH_SHORT).show();
                            ((Inicio)where).FilterProducts(categoryModels.get(position).getCategoryName());
                            return;
                        }

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Product>> call, Throwable t)
                    {
                        Toast.makeText(where,"error"+t.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }



    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CategoryItemBinding categoryBinding;

        public ViewHolder(@NonNull CategoryItemBinding categoryBinding) {
            super(categoryBinding.getRoot());
            this.categoryBinding = categoryBinding;

        }
    }
}
