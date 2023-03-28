package com.example.newsfeed;

public class CategoryRVModel {
    private String category;
    private String catergoryImageUrl;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCatergoryImageUrl() {
        return catergoryImageUrl;
    }

    public void setCatergoryImageUrl(String catergoryImageUrl) {
        this.catergoryImageUrl = catergoryImageUrl;
    }

    public CategoryRVModel(String category, String catergoryImageUrl) {
        this.category = category;
        this.catergoryImageUrl = catergoryImageUrl;
    }
}
