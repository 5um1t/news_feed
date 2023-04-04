package com.example.newsfeed;

public class RecyclerData {

    private String title;
    private int imgId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public RecyclerData(String title, int imgId) {
        this.title = title;
        this.imgId = imgId;
    }
}
