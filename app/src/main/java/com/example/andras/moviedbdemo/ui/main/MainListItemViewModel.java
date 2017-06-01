package com.example.andras.moviedbdemo.ui.main;

import android.view.View;

import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.ui.common.Navigator;

public class MainListItemViewModel {

    private Movie movie;
    private Navigator navigator;

    public MainListItemViewModel(Movie movie, Navigator navigator) {
        this.movie = movie;
        this.navigator = navigator;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getRatingText() {
        return String.valueOf(movie.getRating());
    }

    public String getReleaseYearText() {
        return String.valueOf(movie.getReleaseYear());
    }

    public void goToDetailsPage(View view) {
        navigator.goToDetailsScreen(movie);
    }

}
