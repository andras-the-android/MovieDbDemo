package com.example.andras.moviedbdemo.converter;


import android.util.Log;

import com.example.andras.moviedbdemo.data.MainListItemDto;
import com.example.andras.moviedbdemo.data.tmdb.TmdbTvShow;

import java.util.List;

public class TvShowConverter implements Converter<TmdbTvShow, MainListItemDto> {

    private static final String TAG = "MovieConverter";

    public MainListItemDto convert(TmdbTvShow source) {
        MainListItemDto target = new MainListItemDto();
        target.setTitle(source.getName());
        target.setGenre(getGenre(source.getGenreIds()));
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

    private String getGenre(List<Integer> genres) {
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
