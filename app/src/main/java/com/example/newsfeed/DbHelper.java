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

    public ArrayList<CarouselItem> getCarousalItems(){
        ArrayList<CarouselItem> carousalItemArrayList=new ArrayList<>();

        CarouselItem carousalItem1 =new CarouselItem();
        carousalItem1.setImageResource("https://images.unsplash.com/photo-1486012345871-f47c8c407079?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
        carousalItem1.setTitle("Title 1");
        carousalItem1.setDescription("Description 1");
        carousalItemArrayList.add(carousalItem1);

        CarouselItem carousalItem2 =new CarouselItem();
        carousalItem2.setImageResource("https://images.unsplash.com/photo-1512195740027-7bce37e3fc21?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
        carousalItem2.setTitle("Title 2");
        carousalItem2.setDescription("Description 2");
        carousalItemArrayList.add(carousalItem2);

        CarouselItem carousalItem3 =new CarouselItem();
        carousalItem3.setImageResource("https://images.unsplash.com/photo-1554564761-03c1199a2bd4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1331&q=80");
        carousalItem3.setTitle("Title 3");
        carousalItem3.setDescription("Description 3");
        carousalItemArrayList.add(carousalItem3);

        return carousalItemArrayList;
    }


    public ArrayList<CategoryRVModel> getCategory() {
        ArrayList<CategoryRVModel> categoryRVModelArrayList = new ArrayList<>();

        CategoryRVModel rvModelGeneral = new CategoryRVModel();
        rvModelGeneral.setCategory("general");
        rvModelGeneral.setCategoryImageUrl("https://images.unsplash.com/photo-1504711434969-e33886168f5c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80");
        categoryRVModelArrayList.add(rvModelGeneral);

        CategoryRVModel categoryRVModel = new CategoryRVModel();
        categoryRVModel.setCategory("science");
        categoryRVModel.setCategoryImageUrl("https://images.unsplash.com/photo-1554475900-0a0350e3fc7b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1917&q=80");
        categoryRVModelArrayList.add(categoryRVModel);

        CategoryRVModel rvModelTech = new CategoryRVModel();
        rvModelTech.setCategory("technology");
        rvModelTech.setCategoryImageUrl("https://images.unsplash.com/photo-1518770660439-4636190af475?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
        categoryRVModelArrayList.add(rvModelTech);

        CategoryRVModel rvModelHealth = new CategoryRVModel();
        rvModelHealth.setCategory("health");
        rvModelHealth.setCategoryImageUrl("https://images.unsplash.com/photo-1505751172876-fa1923c5c528?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
        categoryRVModelArrayList.add(rvModelHealth);

        CategoryRVModel rvModelEntertainment = new CategoryRVModel();
        rvModelEntertainment.setCategory("entertainment");
        rvModelEntertainment.setCategoryImageUrl("https://images.unsplash.com/photo-1598899134739-24c46f58b8c0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1156&q=80");
        categoryRVModelArrayList.add(rvModelEntertainment);

        CategoryRVModel rvModelSports = new CategoryRVModel();
        rvModelSports.setCategory("sports");
        rvModelSports.setCategoryImageUrl("https://images.unsplash.com/photo-1601121853354-e6e866bd2bac?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1935&q=80");
        categoryRVModelArrayList.add(rvModelSports);

        return categoryRVModelArrayList;
    }
}

