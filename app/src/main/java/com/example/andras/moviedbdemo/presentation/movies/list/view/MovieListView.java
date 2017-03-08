package com.example.andras.moviedbdemo.presentation.movies.list.view;

import com.example.andras.moviedbdemo.presentation.movies.list.viewmodel.MovieListItemViewModel;

import java.util.List;

/**
 * Created by Andras_Nemeth on 2017. 03. 07..
 */

public interface MovieListView {

    void addItems(List<MovieListItemViewModel> movies);
}
