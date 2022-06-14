package com.aprendiendo.android.Services;

import com.aprendiendo.android.Models.CartItemModel;
import com.aprendiendo.android.Models.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAllCartItems {

    @GET("cart")
    Call<ArrayList<CartItemModel>> GetCart();
}
