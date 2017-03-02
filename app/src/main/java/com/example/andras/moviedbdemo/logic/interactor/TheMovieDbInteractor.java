package com.example.andras.moviedbdemo.logic.interactor;

import com.example.andras.moviedbdemo.logic.data.LoadPopularMoviesResponse;
import com.example.andras.moviedbdemo.logic.network.TheMovieDbApi;

import retrofit2.Callback;

/**
 * Created by Andras_Nemeth on 2017. 03. 02..
 */

public class TheMovieDbInteractor {

    private TheMovieDbApi api;

    public TheMovieDbInteractor(TheMovieDbApi api) {
        this.api = api;
    }

    public void loadPopularMovies(int page, Callback<LoadPopularMoviesResponse> callback) {
        api.getPopularMovies(page).enqueue(callback);
    }
}
