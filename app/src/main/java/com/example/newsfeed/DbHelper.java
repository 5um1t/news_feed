package com.example.newsfeed;

import java.util.ArrayList;

public class DbHelper {
    ArticleModel articleModel = new ArticleModel();

    public DbHelper() {
    }

    public CharSequence helper() {
        articleModel.setTitle("Drone footage shows scale of US tornado wreckage");
        articleModel.setPublishedAt("2023-04-02T04:07:12.5409522Z");
        articleModel.setUrlToImage("https://ichef.bbci.co.uk/news/1024/branded_news/1774A/production/_129247069_cov.png");
        articleModel.setContent("Tornadoes that tore through several US states including Arkansas and Illinois have resulted in several deaths and widespread damage to buildings. Jessica Bahena Hernandez was at a heavy metal gig in… [+247 chars]");
        return null;
    }

    public ArrayList<CarouselItem> getCarousalItems() {
        ArrayList<CarouselItem> carousalItemArrayList = new ArrayList<>();

        CarouselItem carousalItem1 = new CarouselItem();
        carousalItem1.setImageResource("https://images.unsplash.com/photo-1486012345871-f47c8c407079?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
        carousalItem1.setTitle("Title 1");
        carousalItem1.setDescription("Description 1");
        carousalItemArrayList.add(carousalItem1);

        CarouselItem carousalItem2 = new CarouselItem();
        carousalItem2.setImageResource("https://images.unsplash.com/photo-1512195740027-7bce37e3fc21?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
        carousalItem2.setTitle("Title 2");
        carousalItem2.setDescription("Description 2");
        carousalItemArrayList.add(carousalItem2);

        CarouselItem carousalItem3 = new CarouselItem();
        carousalItem3.setImageResource("https://images.unsplash.com/photo-1554564761-03c1199a2bd4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1331&q=80");
        carousalItem3.setTitle("Title 3");
        carousalItem3.setDescription("Description 3");
        carousalItemArrayList.add(carousalItem3);

        return carousalItemArrayList;
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