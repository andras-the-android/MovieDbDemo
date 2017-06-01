package com.example.andras.moviedbdemo.di;

import com.example.andras.moviedbdemo.interactor.MovieConverter;
import com.example.andras.moviedbdemo.interactor.TheMovieDbInteractor;
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
    TheMovieDbInteractor provideTheMovieDbInteractor(TheMovieDbApi api, MovieConverter movieConverter) {
        return new TheMovieDbInteractor(api, movieConverter);
    }
}
