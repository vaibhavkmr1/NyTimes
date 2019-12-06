package com.example.nytimesdemo.di.component;

import com.example.nytimesdemo.view.ui.ArticleListFragment;
import com.example.nytimesdemo.di.module.ArticleViewModelModule;
import com.example.nytimesdemo.di.scope.ArticleScope;

import dagger.Subcomponent;

@ArticleScope
@Subcomponent(modules = ArticleViewModelModule.class)
public interface ArticleComponent {
    void inject(ArticleListFragment articleListFragment);
}
