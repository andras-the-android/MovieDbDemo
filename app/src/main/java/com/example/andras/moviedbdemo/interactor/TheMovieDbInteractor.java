package com.example.andras.moviedbdemo.interactor;

import com.example.andras.moviedbdemo.data.LoadPopularMoviesResponse;
import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.network.TheMovieDbApi;

import java.util.List;

import rx.Observable;

public class TheMovieDbInteractor {

    private TheMovieDbApi api;

    public TheMovieDbInteractor(TheMovieDbApi api) {
        this.api = api;
    }

    public Observable<List<Movie>> loadPopularMovies(int page) {
        return api.getPopularMovies(page).map(LoadPopularMoviesResponse::getMovies);
    }
}
