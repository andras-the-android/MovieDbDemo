package com.example.andras.moviedbdemo.network;

import com.example.andras.moviedbdemo.data.tmdb.TmdbGenreResponse;
import com.example.andras.moviedbdemo.data.tmdb.TmdbMovieResponse;
import com.example.andras.moviedbdemo.data.tmdb.TmdbPerson;
import com.example.andras.moviedbdemo.data.tmdb.TmdbPersonResponse;
import com.example.andras.moviedbdemo.data.tmdb.TmdbTvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

    @GET("genre/movie/list")
    Call<TmdbGenreResponse> getGenresForMovies();

    @GET("genre/tv/list")
    Call<TmdbGenreResponse> getGenresForTvShows();
}
