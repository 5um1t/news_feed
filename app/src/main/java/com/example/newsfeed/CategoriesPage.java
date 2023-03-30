package com.example.newsfeed;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdView;

public class CategoriesPage extends AppCompatActivity {
    private Toolbar tb;
    private TextView tbText;
    private ImageView categoryIV;
    private RecyclerView categories,cNews;
    private ProgressBar pb;
    private AdView adv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        tb = findViewById(R.id.cToolbar);
        tbText = findViewById(R.id.toolbarText);
        categories = findViewById(R.id.categories);
        cNews = findViewById(R.id.cNews);
        pb = findViewById(R.id.cLoading);
        adv = findViewById(R.id.adView);
//        categoryIV=findViewById(R.id.cIVCategory);

    }
}
