package com.example.andras.moviedbdemo.modules.movies.list.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.andras.moviedbdemo.R;
import com.example.andras.moviedbdemo.databinding.ActivityMovieListBinding;
import com.example.andras.moviedbdemo.logic.data.Movie;
import com.example.andras.moviedbdemo.logic.di.TheMovieDbComponent;
import com.example.andras.moviedbdemo.logic.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.modules.movies.list.adapter.MovieListAdapter;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MovieListActivity extends AppCompatActivity {

    private static final String TAG = "MovieDetailActivity";

    @Inject
    TheMovieDbInteractor theMovieDbInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TheMovieDbComponent.Get.component().inject(this);
        ActivityMovieListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list);
        MovieListAdapter adapter = new MovieListAdapter(this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        theMovieDbInteractor.loadPopularMovies(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(new Observer<List<Movie>>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage(), e);
                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        adapter.addItems(movies);
                    }
                });
    }
}
