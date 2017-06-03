package com.example.andras.moviedbdemo.ui.main;

import com.example.andras.moviedbdemo.data.MainListItem;

import java.util.List;


interface MainView {

    void setMovieItems(List<MainListItem> movies);

    void setTvItems(List<MainListItem> movies);
}
