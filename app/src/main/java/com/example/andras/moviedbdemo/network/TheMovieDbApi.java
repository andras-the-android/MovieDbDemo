package com.example.andras.moviedbdemo.network;

import com.example.andras.moviedbdemo.data.tmdb.TmdbMovieResponse;
import com.example.andras.moviedbdemo.data.tmdb.TmdbTvShowResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface TheMovieDbApi {

    @GET("movie/popular")
    Observable<TmdbMovieResponse> getPopularMovies(@Query("page") int page);

    @GET("tv/popular")
    Observable<TmdbTvShowResponse> getPopularTvShows(@Query("page") int page);
}
