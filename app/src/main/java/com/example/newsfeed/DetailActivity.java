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

    ImageButton backBTN, shareBTN;

    String title,url,imageURL,content,desc,publishedAt;
    ImageView imageView;
    TextView titleTV, contentTV, dateTV;
    Button readNewsBTN;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_detail);

        initViews();
        initializeShareBtn();
        setDataToActivity();
        initializeBackBtn();
        initializeReadNewsBtn();
        initAds();
    }

    private void initAds() {
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

    private void initializeReadNewsBtn() {
        //Reading full news
        readNewsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    private void initializeBackBtn() {
        //back to previous page
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void initViews() {
        //Init widgets
        readNewsBTN = findViewById(R.id.readNewsBTN);
        shareBTN = findViewById(R.id.shareBTN);
        backBTN = findViewById(R.id.backBTN);
        titleTV = findViewById(R.id.news_title);
        dateTV = findViewById(R.id.news_date);
        imageView = findViewById(R.id.news_image);
        contentTV = findViewById(R.id.news_content);
    }

    public void setDataToActivity() {
        //setting data using DbHelper
        title=getIntent().getStringExtra("title");
        titleTV.setText(title);
        url=getIntent().getStringExtra("url");
        imageURL=getIntent().getStringExtra("imageURL");
        content=getIntent().getStringExtra("content");
        contentTV.setText(content);
        publishedAt=getIntent().getStringExtra("publishedAt");
        dateTV.setText(publishedAt);
        Picasso.get().load(imageURL).into(imageView);
    }


    public void shareData(String url) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, "Link is :");
        i.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(i, "Choose a Platform!"));
    }

    public void initializeShareBtn() {

        //Sharing url using image button
        shareBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(url);
            }
        });
    }
}