package com.example.pelatihan3.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BeritaService {

    private Retrofit retrofit = null;

    public BeritaAPI getAPI() {
        String BASE_URL = "http://newsapi.org/";

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
