package com.example.andras.moviedbdemo.interactor;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.andras.moviedbdemo.converter.MovieConverter;
import com.example.andras.moviedbdemo.converter.TvShowConverter;
import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.data.tmdb.TmdbMovie;
import com.example.andras.moviedbdemo.data.tmdb.TmdbMovieResponse;
import com.example.andras.moviedbdemo.data.tmdb.TmdbTvShow;
import com.example.andras.moviedbdemo.data.tmdb.TmdbTvShowResponse;
import com.example.andras.moviedbdemo.network.TheMovieDbApi;

import java.util.List;

import rx.Observable;

public class TheMovieDbInteractor {

    private TheMovieDbApi api;
    private MovieConverter movieConverter;
    private TvShowConverter tvShowConverter;

    public TheMovieDbInteractor(TheMovieDbApi api, MovieConverter movieConverter, TvShowConverter tvShowConverter) {
        this.api = api;
        this.movieConverter = movieConverter;
        this.tvShowConverter = tvShowConverter;
    }

    public Observable<List<Movie>> loadPopularMovies(int page) {
        return api.getPopularMovies(page)
                .map(TmdbMovieResponse::getMovies)
                .map(this::mapMovieList);
    }

    public Observable<List<Movie>> loadPopularTvShows(int page) {
        return api.getPopularTvShows(page)
                .map(TmdbTvShowResponse::getTvShows)
                .map(this::mapTvShowList);
    }

    private List<Movie> mapMovieList(List<TmdbMovie> tmdbMovies) {
        return Stream.of(tmdbMovies).map(movieConverter::convert).collect(Collectors.toList());
    }

    private List<Movie> mapTvShowList(List<TmdbTvShow> tmdbTvShows) {
        return Stream.of(tmdbTvShows).map(tvShowConverter::convert).collect(Collectors.toList());
    }
}
