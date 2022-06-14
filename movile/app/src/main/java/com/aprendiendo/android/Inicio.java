package com.aprendiendo.android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.aprendiendo.android.Adapters.CategoryAdapter;
import com.aprendiendo.android.Adapters.ProductAdapter;
import com.aprendiendo.android.Models.CartItemModel;
import com.aprendiendo.android.Models.CategoryModel;
import com.aprendiendo.android.Models.Product;
import com.aprendiendo.android.Models.User;
import com.aprendiendo.android.Services.CreateUserService;
import com.aprendiendo.android.Services.DeleteCartItem;
import com.aprendiendo.android.Services.GetAllCartItems;
import com.aprendiendo.android.Services.GetAllProducts;
import com.aprendiendo.android.databinding.ActivityInicioBinding;

import java.util.ArrayList;
import java.util.Iterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.aprendiendo.android.Services.ipConfig;
import com.aprendiendo.android.Adapters.CategoryAdapter;
import com.google.gson.JsonObject;

import static com.aprendiendo.android.Services.ipConfig.ip;

public class Inicio extends AppCompatActivity {

    Retrofit retrofit;
    ActivityInicioBinding inicioBinding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String llave = "sesion";
    ProductAdapter  productAdapter;
    String userAdress;
    ArrayList<Product> arrayProducts;
    ArrayList<CategoryModel> categoryModel;
    CategoryAdapter cadapter;
    ArrayList<CartItemModel> cartItems;
    int cantCartItems;




    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicioBinding = ActivityInicioBinding.inflate(getLayoutInflater());
        View view = inicioBinding.getRoot();
        setContentView(view);

        Bundle extras = getIntent().getExtras();
        updateRedCounter();
        initElements();
        showCategory();
        GetProducts();


        //Toast.makeText(this,""+compro,Toast.LENGTH_SHORT).show();


        inicioBinding.btCloseSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //elimino el carrito
                retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();
                GetAllCartItems service = retrofit.create(GetAllCartItems.class);
                Call<ArrayList<CartItemModel>> compras = service.GetCart();
                compras.enqueue(new Callback<ArrayList<CartItemModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<CartItemModel>> call, Response<ArrayList<CartItemModel>> response) {
                        cartItems = response.body();
                        for (int i=0;i<cartItems.size();i++)
                        {
                            DeleteCartItem service = retrofit.create(DeleteCartItem.class);
                            Call<JsonObject> cosa = service.DeleteCartItem(cartItems.get(i).getId());
                            cosa.enqueue(new Callback<JsonObject>() {
                                @Override
                                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                                    Toast.makeText(getApplicationContext(),"se elimino el registro",Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<JsonObject> call, Throwable t) {

                                }
                            });

                        }

                    }

                    @Override
                    public void onFailure(Call<ArrayList<CartItemModel>> call, Throwable t) {

                    }
                });


                editor.putBoolean(llave,false);
                editor.apply();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
                //NOS MANDA AL CARRITO
        inicioBinding.ivCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onPostResume() {
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show();
        updateRedCounter();
        super.onPostResume();
    }

        //actualiza el contador de productos en carrito
    public void updateRedCounter()
    {
        retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();
        GetAllCartItems service = retrofit.create(GetAllCartItems.class);
        Call<ArrayList<CartItemModel>> compras = service.GetCart();
        compras.enqueue(new Callback<ArrayList<CartItemModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CartItemModel>> call, Response<ArrayList<CartItemModel>> response) {
                cartItems = response.body();
                cantCartItems = cartItems.size();

                if (cantCartItems!=0)
                {
                    inicioBinding.btCartproductsAlert.setVisibility(View.VISIBLE);
                    inicioBinding.btCartproductsAlert.setText(String.valueOf(cantCartItems));
                }

            }

            @Override
            public void onFailure(Call<ArrayList<CartItemModel>> call, Throwable t) {

            }

        });

    }

    // inicializo un monton de cositas
    private void initElements()
    {
       // Log.d("....TAG....", "initElements function");

        preferences = getSharedPreferences("sesiones",Context.MODE_PRIVATE);
        editor = preferences.edit();
        userAdress = this.preferences.getString("direccion","una direccion");
        inicioBinding.tvUserName.setText("Bienvenido Tu direccion es: "+userAdress);

    }

    //HACE LLAMADO A API Y MUESTRA PRODCUTOS
    public void GetProducts()
    {

        retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();
        GetAllProducts service = retrofit.create(GetAllProducts.class);
        Call<ArrayList<Product>> myProducts = service.GetProducts("");
        myProducts.enqueue(new Callback<ArrayList<Product>>()
        {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                if (!response.isSuccessful())
                {

                   return;

                }else {
                    arrayProducts = response.body();
                    productAdapter = new ProductAdapter(getApplicationContext(),arrayProducts);
                    inicioBinding.rvProduct.setHasFixedSize(true);
                    inicioBinding.rvProduct.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    inicioBinding.rvProduct.setAdapter(productAdapter);
                   }

            }
            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"there is a problem in conection:"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

     //MUESTRA CATEGORIAS EN RECYCLER HORIZONTAL
    public void showCategory()
    {
        Integer[] categoryLogo= {R.drawable.burger,R.drawable.hotdog,R.drawable.pizzas,R.drawable.drinks,R.drawable.postre,R.drawable.pollo,R.drawable.desayuno,R.drawable.oriental,R.drawable.veggie,R.drawable.almuerzo,R.drawable.tacos};
        String[] categoryNames ={"Burgers","Hotdogs","Pizzas","Bebidas","Postres","Pollos","Desayunos","Oriental","Veggie","Almuerzos","Tacos"};
        categoryModel = new ArrayList<>();
        for (int i= 0;i<categoryLogo.length;i++)
        {
            CategoryModel model = new CategoryModel(categoryLogo[i],categoryNames[i]);
            categoryModel.add(model);
            //Toast.makeText(getApplicationContext(),categoryModel.get(i).getCategoryName(),Toast.LENGTH_SHORT).show();

        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(Inicio.this,LinearLayoutManager.HORIZONTAL,false);
        inicioBinding.rvCategories.setLayoutManager(layoutManager);
        inicioBinding.rvCategories.setItemAnimator(new DefaultItemAnimator());
        cadapter = new CategoryAdapter(Inicio.this,categoryModel);
        inicioBinding.rvCategories.setAdapter(cadapter);
    }

    public void FilterProducts(String categoryName)
    {

        retrofit = new Retrofit.Builder().baseUrl(ip).addConverterFactory(GsonConverterFactory.create()).build();
        GetAllProducts service = retrofit.create(GetAllProducts.class);
        Call<ArrayList<Product>> myProducts = service.GetProducts(categoryName);
        myProducts.enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"error no se recibio una respuesta de la api",Toast.LENGTH_SHORT).show();
                }else {
                    ArrayList<Product> productosFiltrados = response.body();
                    productAdapter = new ProductAdapter(getApplicationContext(),productosFiltrados);
                    inicioBinding.rvProduct.setHasFixedSize(true);
                    inicioBinding.rvProduct.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    inicioBinding.rvProduct.setAdapter(productAdapter);


                }
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            }
        });
    }








}