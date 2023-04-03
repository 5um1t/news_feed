package com.example.newsfeed;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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
    private ImageButton backBTN;
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
        backBTN=findViewById(R.id.backBTN);
        adv = findViewById(R.id.adView);

        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
finish();
            }
        });
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adv = findViewById(R.id.adView);
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
        ArticleModel a1 = new ArticleModel("Test", "Test", "test.com", "test.com", "test test test", "testPublished", "test");
        ArticleModel a2 = new ArticleModel("Test", "Test", "test.com", "test.com", "test test test", "testPublished", "test");
        ArticleModel a3 = new ArticleModel("Test", "Test", "test.com", "test.com", "test test test", "testPublished", "test");
        ArticleModel a4 = new ArticleModel("Test", "Test", "test.com", "test.com", "test test test", "testPublished", "test");

        articlesArrayList.add(a1);
        articlesArrayList.add(a2);
        articlesArrayList.add(a3);
        articlesArrayList.add(a4);
    }
    @Override
    public void onCategoryClick(int position) {

    }
}
