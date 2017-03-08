package com.example.andras.moviedbdemo.presentation.movies.list.model;

import android.util.Log;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.andras.moviedbdemo.logic.data.Movie;
import com.example.andras.moviedbdemo.logic.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.presentation.common.Navigator;
import com.example.andras.moviedbdemo.presentation.movies.list.view.MovieListView;
import com.example.andras.moviedbdemo.presentation.movies.list.viewmodel.MovieListItemViewModel;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Andras_Nemeth on 2017. 03. 07..
 */
public class MovieListModel {

    private static final String TAG = "MovieListModel";

    private TheMovieDbInteractor theMovieDbInteractor;
    private Navigator navigator;

    public MovieListModel(TheMovieDbInteractor theMovieDbInteractor, Navigator navigator) {
        this.theMovieDbInteractor = theMovieDbInteractor;
        this.navigator = navigator;
    }

    public void setView(MovieListView view) {
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
                        List<MovieListItemViewModel> viewModels = Stream.of(movies).map(movie -> new MovieListItemViewModel(movie, navigator)).collect(Collectors.toList());
                        view.addItems(viewModels);
                    }
                });
    }

}
