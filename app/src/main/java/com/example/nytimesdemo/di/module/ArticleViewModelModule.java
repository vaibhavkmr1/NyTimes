package com.example.nytimesdemo.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.example.nytimesdemo.model.remote.APIInterface;
import com.example.nytimesdemo.model.remote.ArticleNetworkManager;
import com.example.nytimesdemo.model.repository.ArticleRepository;
import com.example.nytimesdemo.di.scope.ArticleScope;
import com.example.nytimesdemo.viewmodel.CustomViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ArticleViewModelModule {

    @ArticleScope
    @Provides
    ArticleNetworkManager providesArticleNetworkManager(APIInterface apiInterface){
        return new ArticleNetworkManager(apiInterface);
    }

    @ArticleScope
    @Provides
    ArticleRepository providesArticleRepository(ArticleNetworkManager articleNetworkManager){
        return new ArticleRepository(articleNetworkManager);
    }

    @Provides
    @ArticleScope
    ViewModelProvider.Factory provideViewModelFactory(ArticleRepository articleRepository){
        return new CustomViewModelFactory(articleRepository);
    }
}


