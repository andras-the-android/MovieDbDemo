package com.example.andras.moviedbdemo.converter;


import android.util.Log;

import com.example.andras.moviedbdemo.data.MainListItemDto;
import com.example.andras.moviedbdemo.data.tmdb.TmdbMovie;
import com.example.andras.moviedbdemo.interactor.GenreInteractor;

public class MovieConverter implements Converter<TmdbMovie, MainListItemDto> {

    private static final String TAG = "MovieConverter";
    private GenreInteractor genreInteractor;

    public MovieConverter(GenreInteractor genreInteractor) {
        this.genreInteractor = genreInteractor;
    }

    public MainListItemDto convert(TmdbMovie source) {
        MainListItemDto target = new MainListItemDto();
        target.setTitle(source.getTitle());
        target.setGenre(genreInteractor.concatGenresByIdForMovies(source.getGenreIds()));
        target.setRating(source.getAverageVote());
        target.setReleaseYear(getReleaseYear(source.getReleaseDateText()));
        target.setDescription(source.getOverview());
        target.setImageUrl(source.getPosterPath());
        return target;
    }

    private int getReleaseYear(String releaseDateText) {
        try {
            return Integer.valueOf(releaseDateText.substring(0, 4));
        } catch (NumberFormatException e) {
            Log.d(TAG, e.getMessage(), e);
            return 0;
        }
    }
}
