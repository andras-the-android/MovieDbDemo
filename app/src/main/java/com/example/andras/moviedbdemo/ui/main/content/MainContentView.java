package com.example.andras.moviedbdemo.ui.main.content;


import com.example.andras.moviedbdemo.ui.main.listitem.MainListItemViewModel;

import java.util.List;

interface MainContentView {

    void setItems(List<MainListItemViewModel> items);

    void hideLoaderOverlay();
}
