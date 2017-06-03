package com.example.andras.moviedbdemo.di;

import android.app.Activity;

import com.example.andras.moviedbdemo.network.TheMovieDbApiBuilder;
import com.example.andras.moviedbdemo.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {MainModule.class, CommonModule.class})
@Singleton
public interface MainComponent {

    void inject(MainActivity MainActivity);

    final class Get {
        private Get(){}

        static MainComponent component;

        public static MainComponent component(Activity activity) {
            if (component == null) {
                component = DaggerMainComponent.builder()
                        .theMovieDbModule(new TheMovieDbModule())
                        .networkModule(new NetworkModule())
                        .commonModule(new CommonModule(activity))
                        .build();
            }
            return component;
        }

    }
}
