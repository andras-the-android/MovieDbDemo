package com.example.andras.moviedbdemo.ui.main.content;


import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.andras.moviedbdemo.data.MainListItem;
import com.example.andras.moviedbdemo.searcher.Searcher;
import com.example.andras.moviedbdemo.ui.common.Navigator;
import com.example.andras.moviedbdemo.ui.main.listitem.MainListItemViewModel;

import java.util.List;

public class MainContentViewModel {

    private final MainContentView view;
    private final Searcher<MainListItemViewModel> searcher;
    private final Navigator navigator;
    private List<MainListItemViewModel> viewModels;

    public MainContentViewModel(MainContentView view, Searcher<MainListItemViewModel> searcher, Navigator navigator) {
        this.view = view;
        this.searcher = searcher;
        this.navigator = navigator;
        searcher.setMatcher((item, searchExpression) -> item.getDto().getTitle().toLowerCase().contains(searchExpression.toLowerCase()));
    }

    public void setItems(List<MainListItem> items) {
        viewModels = Stream.of(items).map(movie -> new MainListItemViewModel(movie, navigator)).collect(Collectors.toList());
        searcher.setItems(viewModels);
        view.hideLoaderOverlay();
        view.setItems(viewModels);
    }

    public void search(String expression) {
        if (viewModels != null && !viewModels.isEmpty()) {
            view.setItems(searcher.search(expression));
        }
    }
}
