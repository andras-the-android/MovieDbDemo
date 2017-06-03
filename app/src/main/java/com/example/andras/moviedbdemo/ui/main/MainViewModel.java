package com.example.andras.moviedbdemo.ui.main;

import android.util.Log;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.andras.moviedbdemo.data.MainListItem;
import com.example.andras.moviedbdemo.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.ui.common.Navigator;
import com.example.andras.moviedbdemo.ui.main.listitem.MainListItemViewModel;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainViewModel {

    private static final String TAG = "MainViewModel";

    private TheMovieDbInteractor theMovieDbInteractor;

    public MainViewModel(TheMovieDbInteractor theMovieDbInteractor) {
        this.theMovieDbInteractor = theMovieDbInteractor;
    }

    public void setView(MainView view) {
        theMovieDbInteractor.loadPopularMovies(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(view::setMovieItems, this::onError);

        theMovieDbInteractor.loadPopularTvShows(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(view::setTvItems, this::onError);
    }

    private void onError(Throwable e) {
        Log.e(TAG, e.getMessage(), e);
    }

}
