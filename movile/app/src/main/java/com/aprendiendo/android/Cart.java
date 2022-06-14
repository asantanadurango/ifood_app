package com.aprendiendo.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.aprendiendo.android.Adapters.CartAdapter;
import com.aprendiendo.android.Models.CartItemModel;
import com.aprendiendo.android.Models.InvoiceItemModel;
import com.aprendiendo.android.Services.CreateUserService;
import com.aprendiendo.android.Services.DeleteCartItem;
import com.aprendiendo.android.Services.GetAllCartItems;
import com.aprendiendo.android.Services.GetAllProducts;
import com.aprendiendo.android.databinding.ActivityCartBinding;
import com.google.gson.JsonObject;

import java.io.Serializable;
import android.os.Parcelable;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.aprendiendo.android.Services.ipConfig.ip;

public class Cart extends AppCompatActivity {
    private ActivityCartBinding binding;
    Retrofit retrofit;
    CartAdapter cartAdapter;
    ArrayList<CartItemModel> cartProducts;
    ArrayList<InvoiceItemModel> invoiceArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ShowCart();
        HandleButton();
        invoiceArray = new ArrayList<>();


        //Regreso a inicio
        binding.btB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),Inicio.class);
                startActivity(intent);
            }
        });
            // se manda un arrayList con el cart a invoice
        binding.btPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<cartProducts.size();i++)
                {
                    InvoiceItemModel itemModel = new InvoiceItemModel();
                    itemModel.setId(i);
                    itemModel.setName(cartProducts.get(i).getName());
                    itemModel.setCant(cartProducts.get(i).getCant());
                    itemModel.setPriceU(cartProducts.get(i).getPrice());
                    invoiceArray.add(itemModel);
                }
                DeleteAllCart();
                Intent intent = new Intent(getApplicationContext(), InvoiceActivity.class);
                intent.putParcelableArrayListExtra("ARRAYLIST", (ArrayList<? extends Parcelable>) invoiceArray);
                startActivity(intent);
                finish();

            }
        });


    }
        //Elimina todos los registros del carrito en la base de datos.
    public void DeleteAllCart() {
        for(int i=0;i<cartProducts.size();i++)
        {
            retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();
            DeleteCartItem service = retrofit.create(DeleteCartItem.class);
            Call<JsonObject> objeto = service.DeleteCartItem(cartProducts.get(i).getId());
            objeto.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    Toast.makeText(getApplicationContext(),"Has pagado con Exito",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Problema conectando con DB"+t.getMessage(),Toast.LENGTH_SHORT);
                }
            });




        }
    }

   // MUESTRA PRODUCTOS EN CARRITO
     public void ShowCart(){

         retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();
         GetAllCartItems service = retrofit.create(GetAllCartItems.class);
         Call<ArrayList<CartItemModel>> compras = service.GetCart();
         compras.enqueue(new Callback<ArrayList<CartItemModel>>() {
             @Override
             public void onResponse(Call<ArrayList<CartItemModel>> call, Response<ArrayList<CartItemModel>> response)
             {
                 if(!response.isSuccessful())
                 {
                     Toast.makeText(getApplicationContext(),"error no se recibio una respuesta de la api",Toast.LENGTH_SHORT).show();
                 }else
                 {
                     cartProducts = response.body();
                     cartAdapter = new CartAdapter(getApplicationContext(),cartProducts);
                     binding.rvCartProducts.setHasFixedSize(true);
                     binding.rvCartProducts.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                     binding.rvCartProducts.setAdapter(cartAdapter);
                 }
             }
             @Override
             public void onFailure(Call<ArrayList<CartItemModel>> call, Throwable t) {

             }
         });
     }

     public void HandleButton()
     {
         retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();
         GetAllCartItems service = retrofit.create(GetAllCartItems.class);
         Call<ArrayList<CartItemModel>> compras = service.GetCart();
         compras.enqueue(new Callback<ArrayList<CartItemModel>>() {
             @Override
             public void onResponse(Call<ArrayList<CartItemModel>> call, Response<ArrayList<CartItemModel>> response) {
                 cartProducts = response.body();
                 if(cartProducts.size()==0)
                 {
                     binding.tvEmptyCart.setVisibility(View.VISIBLE);


                 }
                 else{
                     Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.botton_rounder_red, null);
                     binding.btPay.setBackground(drawable);
                     binding.btPay.setEnabled(true);
                     binding.tvEmptyCart.setVisibility(View.INVISIBLE);


                 }
             }

             @Override
             public void onFailure(Call<ArrayList<CartItemModel>> call, Throwable t) {

             }
         });

     }

}