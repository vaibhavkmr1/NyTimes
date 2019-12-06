package com.example.nytimesdemo.view.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.nytimesdemo.NyDemoApplication;
import com.example.nytimesdemo.R;
import com.example.nytimesdemo.di.module.ArticleViewModelModule;
import com.example.nytimesdemo.view.adapter.ArticleListAdapter;
import com.example.nytimesdemo.viewmodel.ArticlesViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ArticleListFragment extends Fragment implements ItemClickListner {
    NavController navController;
    ArticlesViewModel articlesViewModel;
    @BindView(R.id.recylerview)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private RecyclerView.LayoutManager layoutManager;
    private ArticleListAdapter articleListAdapter;
    private Context mContext;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mContext = getContext();
        progressBar.setVisibility(View.VISIBLE);
        navController = Navigation.findNavController(view);
        ((NyDemoApplication) getActivity().getApplication())
                .getAppComponent()
                .newArticleComponent(new ArticleViewModelModule())
                .inject(this);
        articlesViewModel = ViewModelProviders.of(this, viewModelFactory).get(ArticlesViewModel.class);
        articlesViewModel.getArticles().observe(this, articles -> {
            Log.d("Articles", articles.getStatus());
            articleListAdapter = new ArticleListAdapter(articles.getResults(), ArticleListFragment.this);
            layoutManager = new LinearLayoutManager(mContext);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(articleListAdapter);
            progressBar.setVisibility(View.INVISIBLE);
        });
        setObserver();
    }


    private void setObserver() {
        articlesViewModel.stateMutableLiveData.observe(this, new Observer<ArticlesViewModel.state>() {
            @Override
            public void onChanged(ArticlesViewModel.state state) {
                if (state == ArticlesViewModel.state.SHOW_ERROR_DAILOG) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(mContext, articlesViewModel.mutableLiveDataError.getValue(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    /**
     * Handle item click and send data to detail fragment
     *
     * @param detail
     * @param title
     */
    @Override
    public void onItemClicked(String detail, String title) {
        Bundle bundle = new Bundle();
        bundle.putString("detail", detail);
        bundle.putString("title", title);
        navController.navigate(R.id.action_articleListFragment_to_articleDetailFragment, bundle);
    }
}
