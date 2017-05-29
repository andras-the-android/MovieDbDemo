package com.example.andras.moviedbdemo.di;

import android.app.Activity;

import com.example.andras.moviedbdemo.network.TheMovieDbApiBuilder;
import com.example.andras.moviedbdemo.ui.list.MovieListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = MoviesModule.class)
@Singleton
public interface MoviesComponent {

    void inject(MovieListActivity MovieListActivity);
    TheMovieDbApiBuilder getTheMovieDbApiBuilder();

    final class Get {
        private Get(){}

        static MoviesComponent component;

        public static MoviesComponent component(Activity activity) {
            if (component == null) {
                component = DaggerMoviesComponent.builder()
                        .theMovieDbModule(new TheMovieDbModule())
                        .networkModule(new NetworkModule())
                        .commonModule(new CommonModule(activity))
                        .build();
            }
            return component;
        }

    }
}
