package com.example.nytimesdemo.model.remote;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.nytimesdemo.BuildConfig;
import com.example.nytimesdemo.dao.Articles;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleNetworkManager {

    private APIInterface apiInterface;
    private Articles articles;

    public ArticleNetworkManager(APIInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    /**
     * Get articles from server through API
     *
     * @return
     * @param mutableLiveDataError
     */
    public MutableLiveData<Articles> getArticles(MutableLiveData<String> mutableLiveDataError) {
        final MutableLiveData<Articles> articlesMutableLiveData = new MutableLiveData<>();
        Call<Articles> call = apiInterface.getArticles(BuildConfig.API_KEY);
        call.enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {
                Log.d("articles", String.valueOf(response.body()));
                if (response != null && response.isSuccessful()) {
                    articles = response.body();
                    articlesMutableLiveData.setValue(articles);
                }
                else {
                    mutableLiveDataError.setValue("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<Articles> call, Throwable t) {
                mutableLiveDataError.setValue("Something went wrong");
            }
        });
        return articlesMutableLiveData;
    }
}
