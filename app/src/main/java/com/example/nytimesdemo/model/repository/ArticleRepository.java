package com.example.nytimesdemo.model.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.nytimesdemo.dao.Articles;
import com.example.nytimesdemo.model.remote.ArticleNetworkManager;

import javax.inject.Inject;

public class ArticleRepository {
    private ArticleNetworkManager articleNetworkManager;

    @Inject
    public ArticleRepository(ArticleNetworkManager articleNetworkManager) {
        this.articleNetworkManager = articleNetworkManager;
    }

    /**
     * get articles from network manager
     *
     * @return
     */
    public MutableLiveData<Articles> getArticles() {
        return articleNetworkManager.getArticles();
    }
}
