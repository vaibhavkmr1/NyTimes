package com.example.nytimesdemo.viewmodel;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.nytimesdemo.dao.Articles;
import com.example.nytimesdemo.model.repository.ArticleRepository;

import javax.inject.Inject;

public class ArticlesViewModel extends ViewModel {
    private ArticleRepository articleRepository;
    public MutableLiveData<String> mutableLiveDataError = new MutableLiveData<>();
    public MutableLiveData<state> stateMutableLiveData = new MutableLiveData<>();

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
        mutableLiveDataError.observeForever(new Observer<String>() {
            @Override
            public void onChanged(String error) {
                stateMutableLiveData.setValue(state.SHOW_ERROR_DAILOG);
            }
        });
        return articleRepository.getArticles(mutableLiveDataError);

    }

    public enum state {
        SHOW_ERROR_DAILOG;
    }
}
