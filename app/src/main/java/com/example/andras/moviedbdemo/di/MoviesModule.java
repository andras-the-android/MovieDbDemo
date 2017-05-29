package com.example.andras.moviedbdemo.di;

import com.example.andras.moviedbdemo.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.ui.common.Navigator;
import com.example.andras.moviedbdemo.ui.list.MovieListViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {TheMovieDbModule.class, CommonModule.class})
class MoviesModule {

    @Provides
    @Singleton
    MovieListViewModel provideMovieListModel(TheMovieDbInteractor theMovieDbInteractor, Navigator navigator) {
        return new MovieListViewModel(theMovieDbInteractor, navigator);
    }
}