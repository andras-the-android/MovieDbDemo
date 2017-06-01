package com.example.andras.moviedbdemo.interactor;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.data.tmdb.TmdbMovie;
import com.example.andras.moviedbdemo.data.tmdb.TmdbMovieResponse;
import com.example.andras.moviedbdemo.network.TheMovieDbApi;

import java.util.List;

import rx.Observable;

public class TheMovieDbInteractor {

    private TheMovieDbApi api;
    private MovieConverter movieConverter;

    public TheMovieDbInteractor(TheMovieDbApi api, MovieConverter movieConverter) {
        this.api = api;
        this.movieConverter = movieConverter;
    }

    public Observable<List<Movie>> loadPopularMovies(int page) {
        return api.getPopularMovies(page)
                .map(TmdbMovieResponse::getMovies)
                .map(this::mapList);
    }

    private List<Movie> mapList(List<TmdbMovie> tmdbMovies) {
        return Stream.of(tmdbMovies).map(movieConverter::convert).collect(Collectors.toList());
    }
}
