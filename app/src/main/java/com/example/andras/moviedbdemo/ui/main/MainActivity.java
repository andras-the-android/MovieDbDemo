package com.example.andras.moviedbdemo.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;

import com.example.andras.moviedbdemo.databinding.ActivityMovieListBinding;
import com.example.andras.moviedbdemo.R;
import com.example.andras.moviedbdemo.di.MoviesComponent;
import com.example.andras.moviedbdemo.ui.common.SearchViewWrapper;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainViewModel model;

    private MainAdapter adapter;
    private SearchViewWrapper searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MoviesComponent.Get.component(this).inject(this);
        ActivityMovieListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list);
        adapter = new MainAdapter();
        setSupportActionBar(binding.toolbar);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        model.setView(this);
    }

    @Override
    public void addItems(List<MainListItemViewModel> movies) {
        adapter.addItems(movies);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        searchView = new SearchViewWrapper(this, menu);
        searchView.setCallback(this::onSearchViewTextChanged);
        return true;
    }

    private void onSearchViewTextChanged(String expression) {
    }
}
