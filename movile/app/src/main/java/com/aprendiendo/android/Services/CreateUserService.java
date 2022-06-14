package com.aprendiendo.android.Services;

import com.aprendiendo.android.Models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CreateUserService {

    @POST("users/add")
    Call<User> CreateUser(@Body User newUser);


}