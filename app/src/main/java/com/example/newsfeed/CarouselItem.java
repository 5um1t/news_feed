package com.example.newsfeed;

public class CarouselItem {

    private final String imageResource;
    private final String title;
    private final String description;

    public CarouselItem(String imageResource, String title, String description) {
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
    }

    public String getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
