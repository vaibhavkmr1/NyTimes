package com.example.nytimesdemo.di.component;

import com.example.nytimesdemo.di.module.ArticleViewModelModule;
import com.example.nytimesdemo.di.scope.ArticleScope;
import com.example.nytimesdemo.view.ArticleActivity;

import dagger.Subcomponent;

@ArticleScope
@Subcomponent(modules = ArticleViewModelModule.class)
public interface ArticleComponent {
    void inject(ArticleActivity articleActivity);
}
