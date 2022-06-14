package com.aprendiendo.android.Services;

import com.aprendiendo.android.Models.CartItemModel;
import com.aprendiendo.android.Models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CreateCartProduct
{
    @POST("cart/add")
    Call<CartItemModel> CreateCartItem(@Body CartItemModel newCartItem);
}
