package com.example.pranitdarazapp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class dbconnect {

    public static Retrofit retrofit = null;
    public static final String base_url="http://10.0.2.2:3000/";
    public static final String image_url="http://10.0.2.2:3000/uploads/";

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:3000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}