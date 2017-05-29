package com.example.andras.moviedbdemo.ui.list;

import android.util.Log;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.ui.common.Navigator;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MovieListViewModel {

    private static final String TAG = "MovieListViewModel";

    private TheMovieDbInteractor theMovieDbInteractor;
    private Navigator navigator;

    public MovieListViewModel(TheMovieDbInteractor theMovieDbInteractor, Navigator navigator) {
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
