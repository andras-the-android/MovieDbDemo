package com.example.andras.moviedbdemo.ui.list;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.andras.moviedbdemo.databinding.ActivityMovieListBinding;
import com.example.andras.moviedbdemo.R;
import com.example.andras.moviedbdemo.di.MoviesComponent;

import java.util.List;

import javax.inject.Inject;

public class MovieListActivity extends AppCompatActivity implements MovieListView {

    @Inject
    MovieListViewModel model;

    private MovieListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MoviesComponent.Get.component(this).inject(this);
        ActivityMovieListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list);
        adapter = new MovieListAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        model.setView(this);
    }

    @Override
    public void addItems(List<MovieListItemViewModel> movies) {
        adapter.addItems(movies);
    }
}
