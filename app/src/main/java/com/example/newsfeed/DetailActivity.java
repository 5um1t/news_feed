package com.example.newsfeed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_detail);

        //Init widgets
        Button readNewsBTN = findViewById(R.id.readNewsBTN);
        ImageButton shareBTN = findViewById(R.id.shareBTN);
        ImageButton backBTN = findViewById(R.id.backBTN);
        TextView titleTV = findViewById(R.id.news_title);
        TextView dateTV = findViewById(R.id.news_date);
        ImageView imageView = findViewById(R.id.news_image);
        TextView contentTV = findViewById(R.id.news_content);
        //setting data using DbHelper
        DbHelper dbHelper = new DbHelper();
        dbHelper.helper();
        titleTV.setText(dbHelper.articleModel.getTitle());
        dateTV.setText(dbHelper.articleModel.getPublishedAt());
        contentTV.setText(dbHelper.articleModel.getContent());
        Picasso.get().load(dbHelper.articleModel.getUrlToImage()).into(imageView);

        //back to previous page
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Reading full news
        readNewsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        //Sharing url using image button
        shareBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(url);
            }
        });

        //Implementing Google ads using admob
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void shareData(String url) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, "Link is :");
        i.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(i, "Choose a Platform!"));
    }
}