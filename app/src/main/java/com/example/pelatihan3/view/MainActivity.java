package com.example.pelatihan3.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pelatihan3.R;
import com.example.pelatihan3.adapter.MainAdapter;
import com.example.pelatihan3.model.ArticlesItem;
import com.example.pelatihan3.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainInterface{

private RecyclerView recyclerView;
private MainAdapter mainAdapter;
private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv1);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        MainPresenter mainPresenter = new MainPresenter(this);
        mainPresenter.getArticlesItem();
    }

    @Override
    public void showList(List<ArticlesItem> articlesItems) {
        mainAdapter = new MainAdapter(this, articlesItems, this);
        recyclerView.setAdapter(mainAdapter);
    }
}
