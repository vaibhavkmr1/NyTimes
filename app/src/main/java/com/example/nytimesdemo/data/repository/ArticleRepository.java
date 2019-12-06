package com.example.nytimesdemo.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nytimesdemo.dao.Articles;
import com.example.nytimesdemo.data.remote.ArticleNetworkManager;

import javax.inject.Inject;

public class ArticleRepository {
    private ArticleNetworkManager articleNetworkManager;

    @Inject
    public ArticleRepository(ArticleNetworkManager articleNetworkManager){
        this.articleNetworkManager=articleNetworkManager;
    }

    public MutableLiveData<Articles> getArticles() {
        return articleNetworkManager.getArticles();
    }
}
