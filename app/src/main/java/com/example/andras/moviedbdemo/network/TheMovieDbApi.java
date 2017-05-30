package com.example.andras.moviedbdemo.network;

import com.example.andras.moviedbdemo.data.TmdbMovieResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface TheMovieDbApi {

    @GET("movie/popular")
    Observable<TmdbMovieResponse> getPopularMovies(@Query("page") int page);

    @GET("tv/popular")
    Observable<TmdbMovieResponse> getPopularTvShows(@Query("page") int page);
}
