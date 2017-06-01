package com.example.andras.moviedbdemo.ui.detail;

import com.example.andras.moviedbdemo.data.Movie;

public class MovieDetailViewModel {

    private Movie movie;

    MovieDetailViewModel(Movie movie) {
        this.movie = movie;
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

}
