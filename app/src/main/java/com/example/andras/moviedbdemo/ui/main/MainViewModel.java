package com.example.andras.moviedbdemo.ui.main;

import android.util.Log;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.ui.common.Navigator;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainViewModel {

    private static final String TAG = "MainViewModel";

    private TheMovieDbInteractor theMovieDbInteractor;
    private Navigator navigator;
    private MainView view;

    public MainViewModel(TheMovieDbInteractor theMovieDbInteractor, Navigator navigator) {
        this.theMovieDbInteractor = theMovieDbInteractor;
        this.navigator = navigator;
    }

    public void setView(MainView view) {
        this.view = view;
        theMovieDbInteractor.loadPopularMovies(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(this::onLoadMoviesFinished, this::onError);
    }

    private void onError(Throwable e) {
        Log.e(TAG, e.getMessage(), e);
    }

    private void onLoadMoviesFinished(List<Movie> movies) {
        List<MainListItemViewModel> viewModels = Stream.of(movies).map(movie -> new MainListItemViewModel(movie, navigator)).collect(Collectors.toList());
        view.addItems(viewModels);
    }

}
