package com.example.newsfeed;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class CategoriesPageActivity extends AppCompatActivity implements CategoryRVAdapter.CategoryClickInterface {
    private Toolbar tb;
    private TextView tbText;
    private ImageView categoryIV;
    private RecyclerView newsRV, categoryRV;
    private ProgressBar loadingPB;
    private ArrayList<ArticleModel> articlesArrayList;
    private ArrayList<CategoryRVModel> categoryRVModels;
    private CategoryRVAdapter categoryRVAdapter;
    private CategoryNewsRVAdapter categoryNewsRVAdapter;
    private AdView adv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        newsRV = findViewById(R.id.cNews);
        categoryRV = findViewById(R.id.categories);
        loadingPB = findViewById(R.id.cLoading);
        articlesArrayList = new ArrayList<>();
        categoryRVModels = new ArrayList<>();
        categoryNewsRVAdapter = new CategoryNewsRVAdapter(articlesArrayList, this);
        categoryRVAdapter = new CategoryRVAdapter(categoryRVModels, this, this::onCategoryClick);
        newsRV.setLayoutManager(new LinearLayoutManager(this));
        newsRV.setAdapter(categoryNewsRVAdapter);
        categoryRV.setAdapter(categoryRVAdapter);
        getCategories();
        getNews();
        tb = findViewById(R.id.cToolbar);
        tbText = findViewById(R.id.toolbarText);
        adv = findViewById(R.id.adView);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adv= findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adv.loadAd(adRequest);
    }


    private void getCategories() {
        categoryRVModels.add(new CategoryRVModel("General", ""));
        categoryRVModels.add(new CategoryRVModel("Business", ""));
        categoryRVModels.add(new CategoryRVModel("Entertainment", ""));
        categoryRVModels.add(new CategoryRVModel("Health", ""));
        categoryRVModels.add(new CategoryRVModel("Science", ""));
        categoryRVModels.add(new CategoryRVModel("Sports", ""));
        categoryRVModels.add(new CategoryRVModel("Technology", ""));
    }

    private void getNews() {
        ArticleModel a1 = new ArticleModel("Test", "Test", "test.com", "test.com", "test test test","testPublished");
        ArticleModel a2 = new ArticleModel("Test", "Test", "test.com", "test.com", "test test test","testPublished");
        ArticleModel a3 = new ArticleModel("Test", "Test", "test.com", "test.com", "test test test","testPublished");
        ArticleModel a4 = new ArticleModel("Test", "Test", "test.com", "test.com", "test test test","testPublished");
        articlesArrayList.add(a1);
        articlesArrayList.add(a2);
        articlesArrayList.add(a3);
        articlesArrayList.add(a4);
    }



    //
//
    @Override
    public void onCategoryClick(int position) {

    }
}
