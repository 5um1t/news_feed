package com.example.newsfeed;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoriesPageActivity extends AppCompatActivity implements CategoryRVAdapter.CategoryClickInterface {
    private ArrayList<ArticleModel> articlesArrayList = new ArrayList<ArticleModel>();
    private RecyclerView newsRV, categoryRV;
    private ProgressBar loadingPB;
    private ArrayList<CategoryRVModel> categoryRVModels;
    private CategoryRVAdapter categoryRVAdapter;
    private CategoryNewsRVAdapter categoryNewsRVAdapter;
    private AdView adv;
    ImageButton backBTN;

    public CategoriesPageActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        String selectedCategory = "General";
        if (getIntent().getExtras() != null) {
            selectedCategory = getIntent().getStringExtra("Category");
        }
        initViews();
        setInitData();
        getCategories();
        getNews(selectedCategory);
        initializeAds();

        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initializeAds() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        adv.loadAd(adRequest);
    }

    private void setInitData() {
        categoryRVModels = new ArrayList<CategoryRVModel>();
        categoryRVAdapter = new CategoryRVAdapter(categoryRVModels, this, this::onCategoryClick);
        categoryRV.setAdapter(categoryRVAdapter);

        categoryNewsRVAdapter = new CategoryNewsRVAdapter(articlesArrayList, this);
        newsRV.setLayoutManager(new LinearLayoutManager(this));
        newsRV.setAdapter(categoryNewsRVAdapter);
    }

    private void initViews() {
        newsRV = findViewById(R.id.cNews);
        categoryRV = findViewById(R.id.categories);
        loadingPB = findViewById(R.id.cLoading);
        adv = findViewById(R.id.adView);
        backBTN = findViewById(R.id.backBTN);
    }

    private void getCategories() {
        DbHelper dbHelper = new DbHelper();
        categoryRVModels.addAll(dbHelper.getCategory());
        categoryRVAdapter.notifyDataSetChanged();
    }

    private void getNews(String category) {
        loadingPB.setVisibility(View.VISIBLE);
        articlesArrayList.clear();
        String categoryURL = "https://newsapi.org/v2/top-headlines?country=in&category=" + category + "&apikey=1db2960de0234c81b3f2b5c5dc509ab3";
        String url = "https://newsapi.org/v2/top-headlines?country=in&sortBy=publishedAt&language=en&apiKey=1db2960de0234c81b3f2b5c5dc509ab3";
        String base_url = "https://newsapi.org/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<NewsModel> call;
        if (category.equals("General")) {
            call = retrofitAPI.getAllNews(url);
        } else {
            call = retrofitAPI.getNewsByCategory(categoryURL);
        }

        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                NewsModel newsModel = response.body();
                loadingPB.setVisibility(View.GONE);
                ArrayList<ArticleModel> articles = newsModel.getArticles();
                for (int i = 0; i < articles.size(); i++) {
                    articlesArrayList.add(new ArticleModel(articles.get(i).getTitle(), articles.get(i).getDescription(),
                            articles.get(i).getUrlToImage(), articles.get(i).getUrl(), articles.get(i).getContent(),
                            articles.get(i).getPublishedAt(), articles.get(i).getAuthor()));
                }
                categoryNewsRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(CategoriesPageActivity.this, "Failed to load news", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCategoryClick(int position) {
        String category = categoryRVModels.get(position).getCategory();
        getNews(category);
        categoryRVAdapter.setSelectedCategory(position);
    }
}