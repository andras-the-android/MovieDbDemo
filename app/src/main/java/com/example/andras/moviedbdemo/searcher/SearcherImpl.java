package com.example.andras.moviedbdemo.searcher;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

public class SearcherImpl<T> implements Searcher<T> {

    private List<T> items;
    private Matcher<T> matcher;

    @Override
    public Searcher<T> setItems(List<T> items) {
        this.items = items;
        return this;
    }

    @Override
    public Searcher<T> setMatcher(Matcher<T> matcher) {
        this.matcher = matcher;
        return this;
    }

    @Override
    public List<T> search(String searchExpression) {
        if (searchExpression == null || searchExpression.length() == 0) {
            return items;
        }

        return Stream.of(items)
                .filter(item -> matcher.isMatches(item, searchExpression))
                .collect(Collectors.toList());
    }



}
