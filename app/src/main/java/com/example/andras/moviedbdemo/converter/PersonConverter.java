package com.example.andras.moviedbdemo.converter;

import com.example.andras.moviedbdemo.data.MainListItemDto;
import com.example.andras.moviedbdemo.data.tmdb.TmdbPerson;

public class PersonConverter implements Converter<TmdbPerson, MainListItemDto> {

    @Override
    public MainListItemDto convert(TmdbPerson source) {
        MainListItemDto target = new MainListItemDto();
        target.setTitle(source.getName());
        target.setImageUrl(source.getProfilePath());
        target.setDescription(source.getBiography());
        target.setPerson(true);
        return target;
    }
}
