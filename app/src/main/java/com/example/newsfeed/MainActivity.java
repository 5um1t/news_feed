package com.example.newsfeed;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdView mAdView;
    private ViewPager2 viewPager;
    private CarouselAdapter adapter;
    private Timer timer;
    private int currentItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initializeAds();
        initGetCategories();
        initCarousel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    private void initCarousel() {
        DbHelper dbHelper=new DbHelper();
        ArrayList<CarouselItem> carouselItemArrayList=dbHelper.getCarousalItems();
        adapter = new CarouselAdapter(carouselItemArrayList);
        viewPager.setAdapter(adapter);

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

        // created new array list..
        ArrayList<RecyclerData> recyclerDataArrayList = new ArrayList<>();

        // get data from dbHelper class
        DbHelper dbHelper = new DbHelper();
        ArrayList<CategoryRVModel> categoryRVModelArrayList = new ArrayList<>();
        categoryRVModelArrayList = dbHelper.getCategory();
//        Intent i = new Intent(MainActivity.this,CategoriesPageActivity.class);
//        i.putParcelableArrayListExtra("categories",categoryRVModelArrayList);

        // added data from arraylist to adapter class.
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(categoryRVModelArrayList, this);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

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