package com.example.andras.moviedbdemo.di;

import com.example.andras.moviedbdemo.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.ui.main.MainViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = TheMovieDbModule.class)
class MainModule {

    @Provides
    @Singleton
    MainViewModel provideMovieListModel(TheMovieDbInteractor theMovieDbInteractor) {
        return new MainViewModel(theMovieDbInteractor);
    }
}