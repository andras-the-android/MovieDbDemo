package com.example.andras.moviedbdemo.di;

import com.example.andras.moviedbdemo.network.TheMovieDbApi;
import com.example.andras.moviedbdemo.network.TheMovieDbApiBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class NetworkModule {

    @Provides
    @Singleton
    TheMovieDbApiBuilder provideTheMovieDbApiBuiler() {
        return new TheMovieDbApiBuilder();
    }


    @Provides
    @Singleton
    TheMovieDbApi provideTheMovieDbApi(TheMovieDbApiBuilder apiBuiler) {
        return apiBuiler.build();
    }
}
