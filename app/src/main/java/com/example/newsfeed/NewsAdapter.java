package com.example.newsfeed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<Artical>articalsArrayList;
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Artical articals=articalsArrayList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, News_page.class);
                i.putExtra("title",articals.getTitle());
                i.putExtra("desc",articals.getDescription());
                i.putExtra("content",articals.getContent());
                i.putExtra("image",articals.getUrlToImage());
                i.putExtra("url",articals.getUrl());
                context.startActivity(i);
            }

        });
    }

    @Override
    public int getItemCount() {
        return articalsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

    }
}
