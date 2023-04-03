package com.example.newsfeed;


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
}

