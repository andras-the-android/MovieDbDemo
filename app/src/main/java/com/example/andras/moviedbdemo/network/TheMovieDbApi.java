package com.example.andras.moviedbdemo.network;

import com.example.andras.moviedbdemo.data.tmdb.TmdbMovieResponse;
import com.example.andras.moviedbdemo.data.tmdb.TmdbPerson;
import com.example.andras.moviedbdemo.data.tmdb.TmdbPersonResponse;
import com.example.andras.moviedbdemo.data.tmdb.TmdbTvShowResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface TheMovieDbApi {

    @GET("movie/popular")
    Observable<TmdbMovieResponse> getPopularMovies();

    @GET("tv/popular")
    Observable<TmdbTvShowResponse> getPopularTvShows();

    @GET("person/popular")
    Observable<TmdbPersonResponse> getPopularPeople();

    @GET("person/{id}")
    Observable<TmdbPerson> getPersonDetails(@Path("id") int id);
}
