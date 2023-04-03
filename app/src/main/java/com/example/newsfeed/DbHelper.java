package com.example.newsfeed;


import com.google.gson.JsonIOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DbHelper {

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
}
