package com.example.pelatihan3.presenter;

import android.util.Log;

import com.example.pelatihan3.model.ArticlesItem;
import com.example.pelatihan3.model.Berita;
import com.example.pelatihan3.service.BeritaService;
import com.example.pelatihan3.view.MainInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private BeritaService beritaService;
    private MainInterface mainInterface;

    public MainPresenter(MainInterface mainInterface) {
        this.mainInterface = mainInterface;
        if (this.beritaService == null)
            beritaService = new BeritaService();
    }

    public void getArticlesItem() {
        beritaService.getAPI().getResult().enqueue(new Callback<Berita>() {


            @Override
            public void onResponse(Call<Berita> call, Response<Berita> response) {
                Berita berita = response.body();

                if (berita != null && berita.getArticles() != null) {
                    List<ArticlesItem> articlesItems = berita.getArticles();
                    mainInterface.showList(articlesItems);
                }
            }

            @Override
            public void onFailure(Call<Berita> call, Throwable t) {

            }
        });

    }

}
