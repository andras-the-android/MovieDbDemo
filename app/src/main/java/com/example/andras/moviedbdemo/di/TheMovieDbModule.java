package com.example.andras.moviedbdemo.di;

import com.example.andras.moviedbdemo.converter.Converter;
import com.example.andras.moviedbdemo.converter.MovieConverter;
import com.example.andras.moviedbdemo.converter.PersonConverter;
import com.example.andras.moviedbdemo.data.MainListItemDto;
import com.example.andras.moviedbdemo.data.tmdb.TmdbMovie;
import com.example.andras.moviedbdemo.data.tmdb.TmdbPerson;
import com.example.andras.moviedbdemo.data.tmdb.TmdbTvShow;
import com.example.andras.moviedbdemo.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.converter.TvShowConverter;
import com.example.andras.moviedbdemo.network.TheMovieDbApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = NetworkModule.class)
class TheMovieDbModule {


    @Provides
    @Singleton
    Converter<TmdbMovie, MainListItemDto> provideMovieConverter() {
        return new MovieConverter();
    }

    @Provides
    @Singleton
    Converter<TmdbTvShow, MainListItemDto> provideTvShowConverter() {
        return new TvShowConverter();
    }

    @Provides
    @Singleton
    Converter<TmdbPerson, MainListItemDto> providePersonConverter() {
        return new PersonConverter();
    }

    @Provides
    @Singleton
    TheMovieDbInteractor provideTheMovieDbInteractor(TheMovieDbApi api,
                                                     Converter<TmdbMovie, MainListItemDto> movieConverter,
                                                     Converter<TmdbTvShow, MainListItemDto> tvShowConverter,
                                                     Converter<TmdbPerson, MainListItemDto> personConverter) {
        return new TheMovieDbInteractor(api, movieConverter, tvShowConverter, personConverter);
    }
}
