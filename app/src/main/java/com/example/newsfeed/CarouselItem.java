package com.example.newsfeed;

public class CarouselItem {

    private String imageResource;
    private String title;
    private String description;

    public CarouselItem(String imageResource, String title, String description) {
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
    }

    public CarouselItem() {

    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
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
