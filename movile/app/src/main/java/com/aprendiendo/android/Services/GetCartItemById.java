package com.aprendiendo.android.Services;

import com.aprendiendo.android.Models.CartItemModel;
import com.aprendiendo.android.Models.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetCartItemById
{

        @GET("cart")
        Call<CartItemModel> GetCartById(@Query("id")Integer id);

}
