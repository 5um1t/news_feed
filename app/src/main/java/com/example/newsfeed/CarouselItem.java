package com.example.newsfeed;

public class CarouselItem {

    private final String imageResource;
    private final String title;

    public CarouselItem(String imageResource, String title) {
        this.imageResource = imageResource;
        this.title = title;
    }

    public String getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

}
