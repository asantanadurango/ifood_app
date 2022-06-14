package com.aprendiendo.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import com.aprendiendo.android.Models.CartItemModel;
import com.aprendiendo.android.Services.CreateCartProduct;
import com.aprendiendo.android.Services.CreateUserService;
import com.aprendiendo.android.databinding.ActivityConfirmPurchaseBinding;
import com.aprendiendo.android.databinding.ActivityMainBinding;
import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.aprendiendo.android.Services.ipConfig.ip;

public class ConfirmPurchase extends AppCompatActivity {
        private ActivityConfirmPurchaseBinding binding;
        public Retrofit retrofit;
        public String name;
        public String image;
        public Integer price;
        public Integer id;

        Integer amount = 1;
       Integer total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmPurchaseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //recibo de inicio los datos del producto seleccionado
        Bundle extras = getIntent().getExtras();
          name = extras.getString("name");
          image = extras.getString("image");
          price = extras.getInt("price");
          id = extras.getInt("id");
         Integer[] precio = {price};

         // muestro todo
        Glide.with(getApplicationContext()).load(image).into(binding.ivFullImage);
        binding.tvTittle.setText(name);
        binding.btConfirm.setText("$"+precio[0]);
        binding.tvAmount.setText(amount.toString());

        //regreso a inicio
        binding.btBackToInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Inicio.class);
                startActivity(intent);
            }
        });
        //boton de aumento
        binding.btPlus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                if(amount==1)
                {
                    amount = amount+1;
                    total = precio[0] * amount;

                    binding.tvAmount.setText(amount.toString());
                    binding.btConfirm.setText("$"+total);
                    binding.btLess.setEnabled(true);
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_less_red, null);
                    binding.btLess.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);

                }else
                {
                    amount = amount+1;
                    total = precio[0] * amount;
                    binding.tvAmount.setText(amount.toString());
                    binding.btConfirm.setText("$"+total);
                }

            }
        });
        //boton de disiminucion
        binding.btLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    if(amount==2)
                    {
                        amount = amount-1;
                        total = precio[0] * amount;
                        binding.btLess.setEnabled(false);
                        binding.btConfirm.setText("$"+total);
                        binding.tvAmount.setText(amount.toString());
                        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_less_black, null);
                        binding.btLess.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                    }
                    else
                    {
                        amount = amount -1;
                        total = precio[0] * amount;
                        binding.btConfirm.setText("$"+total);
                        binding.tvAmount.setText(amount.toString());

                    }

            }
        });
        //confirmo la compra
        binding.btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AddCartItem();
                Intent intent = new Intent(getApplicationContext(),Inicio.class);
                startActivity(intent);
            }
        });


    }

    public void AddCartItem()
    {
        retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();
        CreateCartProduct service = retrofit.create(CreateCartProduct.class);
        CartItemModel cartItemModel = new CartItemModel();
        cartItemModel.setId(id);
        cartItemModel.setCant(amount);
        cartItemModel.setImg_url(image);
        cartItemModel.setName(name);
        cartItemModel.setPrice(price);
        Call<CartItemModel> create = service.CreateCartItem(cartItemModel);
        create.enqueue(new Callback<CartItemModel>() {
            @Override
            public void onResponse(Call<CartItemModel> call, Response<CartItemModel> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"no se pudo agregar al carrito lo sentimos!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Producto agregado al carrito",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CartItemModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"there is a problem in conection:"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}