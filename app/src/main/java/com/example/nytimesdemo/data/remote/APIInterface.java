package com.example.nytimesdemo.data.remote;

import com.example.nytimesdemo.dao.Articles;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("mostpopular/v2/viewed/1.json")
    Call<Articles> getArticles(@Query("api-key") String apiKey);
}
