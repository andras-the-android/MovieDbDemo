package com.example.andras.moviedbdemo.di;

import com.example.andras.moviedbdemo.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.ui.common.Navigator;
import com.example.andras.moviedbdemo.ui.main.MainViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {TheMovieDbModule.class, CommonModule.class})
class MoviesModule {

    @Provides
    @Singleton
    MainViewModel provideMovieListModel(TheMovieDbInteractor theMovieDbInteractor, Navigator navigator) {
        return new MainViewModel(theMovieDbInteractor, navigator);
    }
}