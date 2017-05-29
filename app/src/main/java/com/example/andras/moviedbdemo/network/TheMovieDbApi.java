package com.example.andras.moviedbdemo.network;

import com.example.andras.moviedbdemo.data.LoadPopularMoviesResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface TheMovieDbApi {

    @GET("movie/popular")
    Observable<LoadPopularMoviesResponse> getPopularMovies(@Query("page") int page);
}
