package com.example.andras.moviedbdemo.ui.main;

import com.example.andras.moviedbdemo.data.MainListItemDto;

import java.util.List;


interface MainView {

    void showError();

    void setMovieItems(List<MainListItemDto> movies);

    void setTvItems(List<MainListItemDto> movies);

    void setPersonItems(List<MainListItemDto> mainListItemDtos);
}
