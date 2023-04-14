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

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

        ArticleModel article = articlesArrayList.get(position);
        holder.subHeadingTV.setText(article.getDescription());
        holder.headingTV.setText(article.getTitle());
        holder.publishedAtTV.setText(formatDate(article.getPublishedAt()));
        Picasso.get().load(article.getUrlToImage()).into(holder.newsIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("title", article.getTitle());
                i.putExtra("content", article.getContent());
                i.putExtra("desc", article.getDescription());
                i.putExtra("imageURL", article.getUrlToImage());
                i.putExtra("author",article.getAuthor());
                i.putExtra("url", article.getUrl());
                i.putExtra("publishedAt",article.getPublishedAt());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public String formatDate(String dateTimeString){
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMM dd, yyyy h:mm a");
        String formattedDate = "";
        try {
            Date date = inputFormat.parse(dateTimeString);
            formattedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
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
        private final TextView publishedAtTV;

        @SuppressLint("CutPasteId")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            headingTV = itemView.findViewById(R.id.cHeadingNews);
            subHeadingTV = itemView.findViewById(R.id.cSubheadingNews);
            newsIV = itemView.findViewById(R.id.cIVnews);
            publishedAtTV = itemView.findViewById(R.id.cDateTimeNews);
        }
    }
}
