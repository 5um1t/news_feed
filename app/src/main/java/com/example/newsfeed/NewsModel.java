package com.example.newsfeed;

import java.util.ArrayList;

public class NewsModel {

    private int totalResults;
    private String status;
    private ArrayList<Artical>articals;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Artical> getArticals() {
        return articals;
    }

    public void setArticals(ArrayList<Artical> articals) {
        this.articals = articals;
    }

    public NewsModel(int totalResults, String status, ArrayList<Artical> articals) {
        this.totalResults = totalResults;
        this.status = status;
        this.articals = articals;
    }
}
