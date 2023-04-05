package com.example.newsfeed;


import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DbHelper {

    ArticleModel articleModel = new ArticleModel();

    private String inputJson="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"totalResults\": 10,\n" +
            "  \"articles\": [\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": \"bbc-news\",\n" +
            "        \"name\": \"BBC News\"\n" +
            "      },\n" +
            "      \"author\": \"BBC News\",\n" +
            "      \"title\": \"Drone footage shows scale of US tornado wreckage\",\n" +
            "      \"description\": \"One woman who was at a rock gig in Illinois says she narrowly avoided the roof caving in on her.\",\n" +
            "      \"url\": \"http://www.bbc.co.uk/news/world-us-canada-65152532\",\n" +
            "      \"urlToImage\": \"https://ichef.bbci.co.uk/news/1024/branded_news/1774A/production/_129247069_cov.png\",\n" +
            "      \"publishedAt\": \"2023-04-02T04:07:12.5409522Z\",\n" +
            "      \"content\": \"Tornadoes that tore through several US states including Arkansas and Illinois have resulted in several deaths and widespread damage to buildings.\\r\\nJessica Bahena Hernandez was at a heavy metal gig in… [+247 chars]\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    public ArticleModel[] parseArticle(String inputJson) throws JSONException{
        JSONObject obj = new JSONObject(inputJson);
        JSONArray ArticleArr=obj.getJSONArray("articles");
        ArticleModel[] articles=new ArticleModel[ArticleArr.length()];
        for (int i = 0; i < ArticleArr.length(); i++) {
            JSONObject articleObj = ArticleArr.getJSONObject(i);
            String author = articleObj.getString("author");
            String title = articleObj.getString("title");
            String description = articleObj.getString("description");
            String url = articleObj.getString("url");
            String imageUrl = articleObj.getString("urlToImage");
            String publishedAt = articleObj.getString("publishedAt");
            String content = articleObj.getString("content");

            ArticleModel article = new ArticleModel(author, title, description, url, imageUrl, publishedAt, content);
            articles[i] = article;
        }
        return articles;
    }

    public CharSequence helper() {
        articleModel.setTitle("Drone footage shows scale of US tornado wreckage");
        articleModel.setPublishedAt("2023-04-02T04:07:12.5409522Z");
        articleModel.setUrlToImage("https://ichef.bbci.co.uk/news/1024/branded_news/1774A/production/_129247069_cov.png");
        articleModel.setContent("Tornadoes that tore through several US states including Arkansas and Illinois have resulted in several deaths and widespread damage to buildings. Jessica Bahena Hernandez was at a heavy metal gig in… [+247 chars]");
        return null;
    }

    public static ArrayList<ArticleModel> getNews(String category){

        MyEventListener newsAPICallEventListener;

        String categoryURL = "https://newsapi.org/v2/top-headlines?country=in&category=" + category + "&apikey=1db2960de0234c81b3f2b5c5dc509ab3";
        String url = "https://newsapi.org/v2/top-headlines?country=in&sortBy=publishedAt&language=en&apiKey=1db2960de0234c81b3f2b5c5dc509ab3";
        String base_url = "https://newsapi.org/";
        ArrayList<ArticleModel> articleModelArrayList = new ArrayList<ArticleModel>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<NewsModel> call;
        if (category.equals("General")) {
            call = retrofitAPI.getAllNews(url);
        } else {
            call = retrofitAPI.getNewsByCategory(categoryURL);
        }

        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                NewsModel newsModel = response.body();
                ArrayList<ArticleModel> responseArticleModelArrayList = new ArrayList<ArticleModel>(newsModel.getArticles());
                articleModelArrayList.addAll(responseArticleModelArrayList);
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
//                Toast.makeText(CategoriesPageActivity.this, "Failed to load news", Toast.LENGTH_SHORT).show();
            }
        });
        return articleModelArrayList;
    }
}
