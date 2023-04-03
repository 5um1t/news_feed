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

public class DetailActivity extends AppCompatActivity {
    private AdView mAdView;
    String title, url, imageURL, content, desc, publishedAt;
    private TextView titleTV, dateTV, contentTV, descTV;
    private ImageView imageView;
    private Button readNewsBTN;
    private ImageButton shareBTN, backBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_detail);
        //Getting data from Intent
        title = getIntent().getStringExtra("title");
        url = getIntent().getStringExtra("url");
        imageURL = getIntent().getStringExtra("imageURL");
        content = getIntent().getStringExtra("content");
        desc = getIntent().getStringExtra("desc");
        publishedAt = getIntent().getStringExtra("publishedAt");

        //Init widgets
        titleTV = findViewById(R.id.news_title);
        //descTV=findViewById(R.id.news_description);
        dateTV = findViewById(R.id.news_date);
        contentTV = findViewById(R.id.news_content);
        imageView = findViewById(R.id.news_image);
        readNewsBTN = findViewById(R.id.readNewsBTN);
        shareBTN = findViewById(R.id.shareBTN);
        backBTN = findViewById(R.id.backBTN);

        //Setting date to the widgets
        // titleTV.setText(title);
        //descTV.setText(desc);
        //dateTV.setText(publishedAt);
        //contentTV.setText(content);
        //Picasso.get().load(imageURL).into(imageView);

        //back to Home page
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(i);
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
        mAdView = findViewById(R.id.adView);
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