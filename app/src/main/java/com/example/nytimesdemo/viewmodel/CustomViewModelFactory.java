package com.example.nytimesdemo.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.nytimesdemo.data.repository.ArticleRepository;

public class CustomViewModelFactory implements ViewModelProvider.Factory {
    private ArticleRepository articleRepository;

    public CustomViewModelFactory(ArticleRepository articleRepository){
        this.articleRepository=articleRepository;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(ArticlesViewModel.class))
            return(T) new ArticlesViewModel(articleRepository);
        else
            throw new IllegalArgumentException("ViewModel not found");
    }
}
