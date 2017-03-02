package com.example.andras.moviedbdemo.logic.network;

import com.example.andras.moviedbdemo.logic.data.LoadPopularMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Andras_Nemeth on 2017. 03. 02..
 */

public interface TheMovieDbApi {

    @GET("movie/popular")
    Observable<LoadPopularMoviesResponse> getPopularMovies(@Query("page") int page);
}
