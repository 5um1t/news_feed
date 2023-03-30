package com.example.newsfeed;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.idCourseRV);

        // created new array list..
        recyclerDataArrayList = new ArrayList<>();

        // added data to array list
        recyclerDataArrayList.add(new RecyclerData("Business", R.drawable.download));
        recyclerDataArrayList.add(new RecyclerData("Entertainment", R.drawable.download));
        recyclerDataArrayList.add(new RecyclerData("General", R.drawable.download));
        recyclerDataArrayList.add(new RecyclerData("Health", R.drawable.download2));
        recyclerDataArrayList.add(new RecyclerData("Science", R.drawable.download2));
        recyclerDataArrayList.add(new RecyclerData("Sports", R.drawable.download2));
        recyclerDataArrayList.add(new RecyclerData("Technology", R.drawable.download2));

        // added data from arraylist to adapter class.
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(recyclerDataArrayList, this);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        // carousel

        // Urls of our images.
        String url1 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
        String url2 = "https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp";
        String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";

        @Override protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // we are creating array list for storing our image urls.
            ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

            // initializing the slider view.
            SliderView sliderView = findViewById(R.id.slider);

            // adding the urls inside array list
            sliderDataArrayList.add(new SliderData(url1));
            sliderDataArrayList.add(new SliderData(url2));
            sliderDataArrayList.add(new SliderData(url3));

            // passing this array list inside our adapter class.
            SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

            // below method is used to set auto cycle direction in left to
            // right direction you can change according to requirement.
            sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

            // below method is used to
            // setadapter to sliderview.
            sliderView.setSliderAdapter(adapter);

            // below method is use to set
            // scroll time in seconds.
            sliderView.setScrollTimeInSec(3);

            // to set it scrollable automatically
            // we use below method.
            sliderView.setAutoCycle(true);

            // to start autocycle below method is used.
            sliderView.startAutoCycle();
        }
    }
}


//import android.os.Bundle;
//import android.widget.Toolbar;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    CarouselView carouselView;
//    int[] sampleImages = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4 };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        carouselView = findViewById(R.id.carouselView);
//        carouselView.setPageCount(sampleImages.length);
//        carouselView.setImageListener(imageListener);
//
//    }
//
//    ImageListener imageListener = new ImageListener() {
//        @Override
//        public void setImageForPosition(int position, ImageView imageView) {
//            imageView.setImageResource(sampleImages[position]);
//        }
//    };
//
//}
