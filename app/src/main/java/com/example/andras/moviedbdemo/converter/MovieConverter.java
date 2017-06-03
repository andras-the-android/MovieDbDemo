package com.example.andras.moviedbdemo.converter;


import android.util.Log;

import com.example.andras.moviedbdemo.data.MainListItemDto;
import com.example.andras.moviedbdemo.data.tmdb.Genre;
import com.example.andras.moviedbdemo.data.tmdb.TmdbMovie;

import java.util.List;

public class MovieConverter implements Converter<TmdbMovie, MainListItemDto> {

    private static final String TAG = "MovieConverter";

    public MainListItemDto convert(TmdbMovie source) {
        MainListItemDto target = new MainListItemDto();
        target.setTitle(source.getTitle());
        target.setGenre(getGenre(source.getGenres()));
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

    private String getGenre(List<Genre> genres) {
//        StringBuffer sb = new StringBuffer();
//        for (Genre genre : genres) {
//            if (sb.length() > 0) {
//                sb.append(", ");
//            }
//            sb.append(genre.getName());
//        }
//        return sb.toString();
        return "temp genre";
    }
}
