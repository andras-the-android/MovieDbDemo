package com.example.andras.moviedbdemo.ui.main;

import com.example.andras.moviedbdemo.ui.main.listitem.MainListItemViewModel;

import java.util.List;


interface MainView {

    void setMovieItems(List<MainListItemViewModel> movies);

    void setTvItems(List<MainListItemViewModel> movies);
}
