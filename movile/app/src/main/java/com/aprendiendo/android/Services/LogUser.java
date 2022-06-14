package com.aprendiendo.android.Services;

import com.aprendiendo.android.Models.User;
import com.aprendiendo.android.Models.UserLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LogUser {

    @POST("users/login")
    Call<User> LogUser(@Body UserLogin user);

}
