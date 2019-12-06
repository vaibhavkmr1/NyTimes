package com.example.nytimesdemo.data.remote;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.nytimesdemo.dao.Articles;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleNetworkManager {

    private APIInterface apiInterface;
    private Articles articles;

    public ArticleNetworkManager(APIInterface apiInterface){
        this.apiInterface=apiInterface;
    }

    public MutableLiveData<Articles> getArticles() {
        final MutableLiveData<Articles> articlesMutableLiveData = new MutableLiveData<>();
        Call<Articles> call = apiInterface.getArticles("ByPGKWu7cDKZiihtoeFKu7AnQEzX4BW1");
        call.enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {
                Log.d("articles", String.valueOf(response.body()));
                if (response != null && response.isSuccessful()) {
                    articles=response.body();
                    articlesMutableLiveData.setValue(articles);
                }
            }

            @Override
            public void onFailure(Call<Articles> call, Throwable t) {

            }
        });
        return articlesMutableLiveData;
    }
}
