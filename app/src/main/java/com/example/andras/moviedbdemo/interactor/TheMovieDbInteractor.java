package com.example.andras.moviedbdemo.interactor;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.andras.moviedbdemo.converter.Converter;
import com.example.andras.moviedbdemo.data.MainListItemDto;
import com.example.andras.moviedbdemo.data.tmdb.TmdbMovie;
import com.example.andras.moviedbdemo.data.tmdb.TmdbMovieResponse;
import com.example.andras.moviedbdemo.data.tmdb.TmdbPerson;
import com.example.andras.moviedbdemo.data.tmdb.TmdbPersonResponse;
import com.example.andras.moviedbdemo.data.tmdb.TmdbTvShow;
import com.example.andras.moviedbdemo.data.tmdb.TmdbTvShowResponse;
import com.example.andras.moviedbdemo.network.TheMovieDbApi;

import java.util.List;

import rx.Observable;

public class TheMovieDbInteractor {

    private TheMovieDbApi api;
    private Converter<TmdbMovie, MainListItemDto> movieConverter;
    private Converter<TmdbTvShow, MainListItemDto> tvShowConverter;
    private Converter<TmdbPerson, MainListItemDto> personConverter;

    public TheMovieDbInteractor(TheMovieDbApi api,
                                Converter<TmdbMovie, MainListItemDto> movieConverter,
                                Converter<TmdbTvShow, MainListItemDto> tvShowConverter,
                                Converter<TmdbPerson, MainListItemDto> personConverter) {
        this.api = api;
        this.movieConverter = movieConverter;
        this.tvShowConverter = tvShowConverter;
        this.personConverter = personConverter;
    }

    public Observable<List<MainListItemDto>> loadPopularMovies() {
        return api.getPopularMovies()
                .map(TmdbMovieResponse::getMovies)
                .map(this::mapMovieList);
    }

    public Observable<List<MainListItemDto>> loadPopularTvShows() {
        return api.getPopularTvShows()
                .map(TmdbTvShowResponse::getTvShows)
                .map(this::mapTvShowList);
    }

    public Observable<List<MainListItemDto>> loadPopularPeople() {
        return api.getPopularPeople()
                .map(TmdbPersonResponse::getPeople)
                .map(this::mapPersonList);
    }

    private List<MainListItemDto> mapMovieList(List<TmdbMovie> tmdbMovies) {
        return Stream.of(tmdbMovies).map(movieConverter::convert).collect(Collectors.toList());
    }

    private List<MainListItemDto> mapTvShowList(List<TmdbTvShow> tmdbTvShows) {
        return Stream.of(tmdbTvShows).map(tvShowConverter::convert).collect(Collectors.toList());
    }

    private List<MainListItemDto> mapPersonList(List<TmdbPerson> tmdbTvShows) {
        return Stream.of(tmdbTvShows).map(personConverter::convert).collect(Collectors.toList());
    }
}
