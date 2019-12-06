package com.example.nytimesdemo.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.nytimesdemo.NyDemoApplication;
import com.example.nytimesdemo.R;
import com.example.nytimesdemo.dao.Articles;
import com.example.nytimesdemo.di.module.ArticleViewModelModule;
import com.example.nytimesdemo.viewmodel.ArticlesViewModel;

import javax.inject.Inject;

public class ArticleActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
       }
}
