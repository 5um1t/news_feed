package com.example.newsfeed;

import java.util.ArrayList;

public class DbHelper {

    public DbHelper() {
    }

    public ArrayList<CategoryRVModel> getCategory() {
        ArrayList<CategoryRVModel> categoryRVModelArrayList = new ArrayList<CategoryRVModel>();
        categoryRVModelArrayList.add(new CategoryRVModel("General", "https://img.freepik.com/free-vector/global-technology-earth-news-bulletin-background_1017-33687.jpg"));
        categoryRVModelArrayList.add(new CategoryRVModel("Business", "https://www.snowsoftware.com/wp-content/uploads/2022/02/Home_Pillar_Tile_2b.jpg"));
        categoryRVModelArrayList.add(new CategoryRVModel("Entertainment", "https://blog.ipleaders.in/wp-content/uploads/2020/06/netflix-amazon-india-streaming_1547808042873.jpg"));
        categoryRVModelArrayList.add(new CategoryRVModel("Health", "https://www.shutterstock.com/image-photo/hand-arranging-wood-block-healthcare-260nw-1561815367.jpg"));
        categoryRVModelArrayList.add(new CategoryRVModel("Science", "https://media.istockphoto.com/id/1150397417/photo/abstract-luminous-dna-molecule-doctor-using-tablet-and-check-with-analysis-chromosome-dna.jpg?s=612x612&w=0&k=20&c=WKApDIgCaSrcQ_pGOkDoKZLt6hUvx7coT3hMsV5aF9E="));
        categoryRVModelArrayList.add(new CategoryRVModel("Sports", "https://thumbs.dreamstime.com/b/sports-tools-balls-shoes-ground-108686133.jpg"));
        categoryRVModelArrayList.add(new CategoryRVModel("Technology", "https://thumbs.dreamstime.com/b/internet-information-technology-concept-laptop-computer-showing-data-processing-screen-122397310.jpg"));
        return categoryRVModelArrayList;
    }
}