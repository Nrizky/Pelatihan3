package com.example.pelatihan3.service;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseApp extends Application {


    private Retrofit retrofit = null;

    public BeritaAPI getAPI() {
        String BASE_URL = "https://newsapi.org/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(BeritaAPI.class);
    }

}
