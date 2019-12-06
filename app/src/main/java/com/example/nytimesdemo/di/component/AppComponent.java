package com.example.nytimesdemo.di.component;

import com.example.nytimesdemo.NyDemoApplication;
import com.example.nytimesdemo.di.module.ApiModule;
import com.example.nytimesdemo.di.module.AppModule;
import com.example.nytimesdemo.di.module.ArticleViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules= {AppModule.class, ApiModule.class})
public interface AppComponent {
    void inject(NyDemoApplication nyDemoApplication);
    ArticleComponent newArticleComponent(ArticleViewModelModule articleViewModelModule);
}
