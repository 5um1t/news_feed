package com.example.newsfeed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryNewsRVAdapter extends RecyclerView.Adapter<CategoryNewsRVAdapter.ViewHolder> {

    private final ArrayList<ArticleModel> articlesArrayList;
    private final Context context;

    public CategoryNewsRVAdapter(ArrayList<ArticleModel> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_rv_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticleModel articles = articlesArrayList.get(position);
        holder.subHeadingTV.setText(articles.getDescription());
        holder.headingTV.setText(articles.getTitle());
//        Picasso.get().load(articles.getUrlToImage()).into(holder.newsIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("title", articles.getTitle());
                i.putExtra("content", articles.getContent());
                i.putExtra("desc", articles.getDescription());
                i.putExtra("image", articles.getUrlToImage());
                i.putExtra("url", articles.getUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    private static class NewsModel {
        private final String image;
        private final String heading;
        private final String subheading;

        public NewsModel(String image, String heading, String subheading) {
            this.image = image;
            this.heading = heading;
            this.subheading = subheading;
        }

        public String getImageUrl() {
            return image;
        }

        public String getHeading() {
            return heading;
        }

        public String getSubheading() {
            return subheading;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView headingTV;
        private final TextView subHeadingTV;
        private final ImageView newsIV;

        @SuppressLint("CutPasteId")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            headingTV = itemView.findViewById(R.id.cHeadingNews);
            subHeadingTV = itemView.findViewById(R.id.cHeadingNews);
            newsIV = itemView.findViewById(R.id.cIVnews);
        }
    }
}
