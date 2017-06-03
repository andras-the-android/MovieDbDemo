package com.example.andras.moviedbdemo.converter;

import com.example.andras.moviedbdemo.data.MainListItemDto;
import com.example.andras.moviedbdemo.data.tmdb.TmdbPerson;

public class PersonConverter implements Converter<TmdbPerson, MainListItemDto> {
    @Override
    public MainListItemDto convert(TmdbPerson source) {
        MainListItemDto target = new MainListItemDto();
        target.setTitle(source.getName());
        target.setImageUrl(source.getProfilePath());
        target.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        target.setPerson(true);
        return target;
    }
}
