package com.example.nytimesdemo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.nytimesdemo.dao.Articles;
import com.example.nytimesdemo.data.repository.ArticleRepository;

import javax.inject.Inject;

public class ArticlesViewModel extends ViewModel {
    private ArticleRepository articleRepository;


    @Inject
    public ArticlesViewModel(ArticleRepository articleRepository) {
        this.articleRepository=articleRepository;
    }

    public LiveData<Articles> getArticles() {
        return articleRepository.getArticles();
    }
}
