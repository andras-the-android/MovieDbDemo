package com.example.andras.moviedbdemo.searcher;

import java.util.List;

public interface Searcher<T> {
    List<T> search(String searchExpression);

    Searcher<T> setItems(List<T> items);

    Searcher<T> setMatcher(Matcher<T> matcher);

    public interface Matcher<T> {

        boolean isMatches(T item, String searchExpression);
    }
}
