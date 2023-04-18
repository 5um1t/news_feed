package com.example.newsfeed;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdView mAdView;
    private ViewPager2 viewPager;
    private CarouselAdapter carouselAdapter;

    private Timer timer;
    private int currentItem = 0;
    private ArrayList<ArticleModel> articleModelArrayList = new ArrayList<ArticleModel>();

    private ArrayList<CarouselItem> carouselItemArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initializeAds();
        initGetCategories();
        getCarouselNews();
        initCarousel();
    }

    private void getCarouselNews() {

        articleModelArrayList.clear();
        String url = "https://newsapi.org/v2/top-headlines?country=in&sortBy=publishedAt&language=en&apiKey=1db2960de0234c81b3f2b5c5dc509ab3";
        String base_url = "https://newsapi.org/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<NewsModel> call;
        call = retrofitAPI.getCarouselNews(url);

        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                NewsModel newsModel = response.body();
                assert newsModel != null;
                ArrayList<ArticleModel> articleModelArrayList1 = newsModel.getArticles();

                for (int i = 0; i < 4; i++) {
                    ArticleModel articleModel = articleModelArrayList1.get(i);
                    carouselItemArrayList.add(new CarouselItem( articleModel.getUrlToImage(),articleModel.getTitle()));
                }
                carouselAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to Load news in Carousel", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    private void initCarousel() {
        carouselAdapter = new CarouselAdapter(carouselItemArrayList);
        viewPager.setAdapter(carouselAdapter);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        currentItem++;
                        if (currentItem >= carouselItemArrayList.size()) {
                            currentItem = 0;
                        }
                        viewPager.setCurrentItem(currentItem);
                    }
                });
            }
        }, 5000, 5000); // Change images every 5 seconds
    }

    private void initViews() {
        recyclerView = findViewById(R.id.idCourseRV);
        mAdView = findViewById(R.id.adView);
        viewPager = findViewById(R.id.view_pager);
    }

    private void initGetCategories() {
        //init view

        // get data from dbHelper class
        DbHelper dbHelper = new DbHelper();
        ArrayList<CategoryRVModel> categoryRVModelArrayList = new ArrayList<>();
        categoryRVModelArrayList = dbHelper.getCategory();

        // added data from arraylist to adapter class.

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(categoryRVModelArrayList, this);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager;
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            layoutManager = new GridLayoutManager(this, 3);
        }else{
            layoutManager=new GridLayoutManager(this,7);
        }

        // set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initializeAds() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}