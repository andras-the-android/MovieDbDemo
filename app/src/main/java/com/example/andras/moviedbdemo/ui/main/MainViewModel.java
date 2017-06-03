package com.example.andras.moviedbdemo.ui.main;

import android.util.Log;

import com.example.andras.moviedbdemo.interactor.TheMovieDbInteractor;

import java.util.Collections;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainViewModel {

    private static final String TAG = "MainViewModel";

    private TheMovieDbInteractor theMovieDbInteractor;
    private MainView view;

    public MainViewModel(TheMovieDbInteractor theMovieDbInteractor) {
        this.theMovieDbInteractor = theMovieDbInteractor;
    }

    public void setView(MainView view) {
        this.view = view;
        theMovieDbInteractor.loadPopularMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(view::setMovieItems, t -> {view.setMovieItems(Collections.emptyList()); onError(t);});

        theMovieDbInteractor.loadPopularTvShows()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(view::setTvItems, t -> {view.setTvItems(Collections.emptyList()); onError(t);});

        theMovieDbInteractor.loadPopularPeople()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(view::setPersonItems, t -> {view.setPersonItems(Collections.emptyList()); onError(t);});
    }

    private void onError(Throwable t) {
        Log.e(TAG, t.getMessage(), t);
        view.showError();
    }

}
