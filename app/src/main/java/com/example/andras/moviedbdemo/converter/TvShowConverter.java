package com.example.andras.moviedbdemo.converter;


import android.util.Log;

import com.example.andras.moviedbdemo.data.MainListItemDto;
import com.example.andras.moviedbdemo.data.tmdb.TmdbTvShow;
import com.example.andras.moviedbdemo.interactor.GenreInteractor;

public class TvShowConverter implements Converter<TmdbTvShow, MainListItemDto> {

    private static final String TAG = "MovieConverter";
    private GenreInteractor genreInteractor;

    public TvShowConverter(GenreInteractor genreInteractor) {
        this.genreInteractor = genreInteractor;
    }

    public MainListItemDto convert(TmdbTvShow source) {
        MainListItemDto target = new MainListItemDto();
        target.setTitle(source.getName());
        target.setGenre(genreInteractor.concatGenresByIdForTvShows(source.getGenreIds()));
        target.setRating(source.getVoteAverage());
        target.setReleaseYear(getReleaseYear(source.getFirstAirDate()));
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
