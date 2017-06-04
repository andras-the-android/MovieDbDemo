package com.example.andras.moviedbdemo.interactor;

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
                .map(tmdbMovies -> Stream.of(tmdbMovies).map(movieConverter::convert).toList());
    }

    public Observable<List<MainListItemDto>> loadPopularTvShows() {
        return api.getPopularTvShows()
                .map(TmdbTvShowResponse::getTvShows)
                .map(tmdbTvShows -> Stream.of(tmdbTvShows).map(tvShowConverter::convert).toList());
    }

    /**
     * Tmdb getPopularPeople api provides only a few information so for the detailed profiles we have to
     * call the getPersonDetail api with the id-s one-by-one.
     */
    public Observable<List<MainListItemDto>> loadPopularPeople() {
        Observable<Observable<TmdbPerson>> personDetails = api.getPopularPeople()
                .map(TmdbPersonResponse::getPeople)
                .flatMap(Observable::from)
                .map(tmdbPerson -> api.getPersonDetails(tmdbPerson.getId()));

        return Observable.zip(personDetails, tmdbPersonObjects -> Stream.of(tmdbPersonObjects).map(object -> personConverter.convert((TmdbPerson)object)).toList());
    }

}
