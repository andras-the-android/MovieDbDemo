package com.example.andras.moviedbdemo.ui.detail;

import com.example.andras.moviedbdemo.data.MainListItemDto;

public class MovieDetailViewModel {

    private MainListItemDto dto;

    MovieDetailViewModel(MainListItemDto dto) {
        this.dto = dto;
    }

    public MainListItemDto getDto() {
        return dto;
    }

    public String getRatingText() {
        return String.valueOf(dto.getRating());
    }

    public String getReleaseYearText() {
        return String.valueOf(dto.getReleaseYear());
    }

}
