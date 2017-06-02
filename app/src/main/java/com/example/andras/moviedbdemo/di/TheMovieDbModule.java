package com.example.andras.moviedbdemo.di;

import com.example.andras.moviedbdemo.converter.MovieConverter;
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
    MovieConverter provideMovieConverter() {
        return new MovieConverter();
    }

    @Provides
    @Singleton
    TvShowConverter provideTvShowConverter() {
        return new TvShowConverter();
    }

    @Provides
    @Singleton
    TheMovieDbInteractor provideTheMovieDbInteractor(TheMovieDbApi api, MovieConverter movieConverter, TvShowConverter tvShowConverter) {
        return new TheMovieDbInteractor(api, movieConverter, tvShowConverter);
    }
}
