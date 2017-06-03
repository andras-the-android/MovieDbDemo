package com.example.andras.moviedbdemo.ui.detail;

import com.example.andras.moviedbdemo.data.MainListItemDto;

public class MovieDetailViewModel {

    private MainListItemDto mainListItem;

    MovieDetailViewModel(MainListItemDto mainListItem) {
        this.mainListItem = mainListItem;
    }

    public MainListItemDto getMainListItem() {
        return mainListItem;
    }

    public String getRatingText() {
        return String.valueOf(mainListItem.getRating());
    }

    public String getReleaseYearText() {
        return String.valueOf(mainListItem.getReleaseYear());
    }

}
