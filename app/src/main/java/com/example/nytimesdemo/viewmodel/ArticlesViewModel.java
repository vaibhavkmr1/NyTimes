package com.example.nytimesdemo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.nytimesdemo.dao.Articles;
import com.example.nytimesdemo.model.repository.ArticleRepository;

import javax.inject.Inject;

public class ArticlesViewModel extends ViewModel {
    private ArticleRepository articleRepository;


    @Inject
    public ArticlesViewModel(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * get articles from repostory
     *
     * @return
     */
    public LiveData<Articles> getArticles() {
        return articleRepository.getArticles();
    }
}
