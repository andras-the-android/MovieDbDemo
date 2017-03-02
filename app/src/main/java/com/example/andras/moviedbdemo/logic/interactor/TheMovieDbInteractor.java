package com.example.andras.moviedbdemo.logic.interactor;

import com.example.andras.moviedbdemo.logic.data.LoadPopularMoviesResponse;
import com.example.andras.moviedbdemo.logic.data.Movie;
import com.example.andras.moviedbdemo.logic.network.TheMovieDbApi;

import java.util.List;

import retrofit2.Callback;
import rx.Observable;

/**
 * Created by Andras_Nemeth on 2017. 03. 02..
 */

public class TheMovieDbInteractor {

    private TheMovieDbApi api;

    public TheMovieDbInteractor(TheMovieDbApi api) {
        this.api = api;
    }

    public Observable<List<Movie>> loadPopularMovies(int page) {
        return api.getPopularMovies(page).map(LoadPopularMoviesResponse::getMovies);
    }
}
