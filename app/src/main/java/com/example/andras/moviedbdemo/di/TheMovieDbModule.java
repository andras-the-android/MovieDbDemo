package com.example.andras.moviedbdemo.di;

import com.example.andras.moviedbdemo.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.network.TheMovieDbApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = NetworkModule.class)
class TheMovieDbModule {


    @Provides
    @Singleton
    TheMovieDbInteractor provideTheMovieDbInteractor(TheMovieDbApi api) {
        return new TheMovieDbInteractor(api);
    }
}
