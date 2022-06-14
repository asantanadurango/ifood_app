package com.aprendiendo.android.Services;

import com.aprendiendo.android.Models.CartItemModel;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DeleteCartItem
{
        @DELETE("cart/delete/{id}")
        Call<JsonObject> DeleteCartItem(@Path("id") int id);
}

