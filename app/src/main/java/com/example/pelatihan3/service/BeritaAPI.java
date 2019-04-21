package com.example.pelatihan3.service;

import com.example.pelatihan3.model.Berita;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BeritaAPI {
    @GET("v2/top-headlines?country=id&apiKey=e547379d47634b31979d93eb4b04be12")
    Call<Berita> getResult();
}
