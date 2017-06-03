package com.example.andras.moviedbdemo.ui.detail;

import com.example.andras.moviedbdemo.data.MainListItem;

public class MovieDetailViewModel {

    private MainListItem mainListItem;

    MovieDetailViewModel(MainListItem mainListItem) {
        this.mainListItem = mainListItem;
    }

    public MainListItem getMainListItem() {
        return mainListItem;
    }

    public String getRatingText() {
        return String.valueOf(mainListItem.getRating());
    }

    public String getReleaseYearText() {
        return String.valueOf(mainListItem.getReleaseYear());
    }

}
