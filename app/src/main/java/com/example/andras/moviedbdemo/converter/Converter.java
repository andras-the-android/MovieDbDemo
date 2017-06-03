package com.example.andras.moviedbdemo.converter;


public interface Converter<S, T> {

    T convert(S source);
}
