package com.example.newsfeed;

import java.util.ArrayList;

public class DbHelper {
    ArticleModel articleModel = new ArticleModel();

    public DbHelper() {
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

