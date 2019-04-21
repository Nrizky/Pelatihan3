package com.example.pelatihan3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pelatihan3.R;
import com.example.pelatihan3.model.ArticlesItem;
import com.example.pelatihan3.model.Berita;
import com.example.pelatihan3.view.MainInterface;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private Context context;
    private List<ArticlesItem> articlesItems;
    private MainInterface mainInterface;

    public MainAdapter(Context context, List<ArticlesItem> articlesItems, MainInterface mainInterface) {
        this.context = context;
        this.articlesItems = articlesItems;
        this.mainInterface = mainInterface;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,viewGroup,false);
        ViewHolder mainViewHolder = new ViewHolder(view);
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder viewHolder, int i) {
        ArticlesItem articlesItem = articlesItems.get(i);

        viewHolder.judul.setText(articlesItem.getTitle());
        viewHolder.desc.setText(articlesItem.getDescription());
        viewHolder.author.setText(articlesItem.getAuthor());
        viewHolder.mainInterface = mainInterface;
        Picasso.get().load(articlesItem.getUrlToImage()).into(viewHolder.cover);


    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cover;
        TextView judul, desc, author;
        FrameLayout frameLayout;
        MainInterface mainInterface;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.rviv_main_cover);
            judul = itemView.findViewById(R.id.rvtv_main_title);
            desc = itemView.findViewById(R.id.rvtv_main_desc);
            author = itemView.findViewById(R.id.rvtv_main_author);
            frameLayout = itemView.findViewById(R.id.rvfl_main);

        }
    }
}
