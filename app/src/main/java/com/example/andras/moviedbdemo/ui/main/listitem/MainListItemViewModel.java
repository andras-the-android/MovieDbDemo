package com.example.andras.moviedbdemo.ui.main.listitem;

import android.view.View;

import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.ui.common.Navigator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainListItemViewModel {

    private static NumberFormat ratingFormat;
    static {
        ratingFormat = new DecimalFormat("#.0");
        ratingFormat.setRoundingMode(RoundingMode.HALF_UP);
    }

    private Movie movie;
    private Navigator navigator;
    private MainListItemView view;

    public MainListItemViewModel(Movie movie, Navigator navigator) {
        this.movie = movie;
        this.navigator = navigator;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getRatingText() {
        return ratingFormat.format(movie.getRating());
    }

    public String getReleaseYearText() {
        return String.valueOf(movie.getReleaseYear());
    }

    public void goToDetailsPage(View v) {
        navigator.goToDetailsScreen(movie, this.view.getTransitionBundle());
    }

    public void setView(MainListItemView view) {
        this.view = view;
    }
}
