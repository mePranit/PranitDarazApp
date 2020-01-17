package com.example.pranitdarazapp.Retrofit;


import com.example.pranitdarazapp.modal.Collection;
import com.example.pranitdarazapp.modal.Products;
import com.example.pranitdarazapp.modal.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    @GET("products")
    Call<List<Products>> getProduct();

    @GET("collections")
    Call<List<Collection>> getCollection();

    @POST("users")
    Call <Void> registerUser(@Body Users users);


}