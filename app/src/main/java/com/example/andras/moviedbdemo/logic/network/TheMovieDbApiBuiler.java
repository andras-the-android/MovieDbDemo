package com.example.andras.moviedbdemo.logic.network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andras_Nemeth on 2017. 03. 02..
 */

public class TheMovieDbApiBuiler {

    private static final String API_KEY = "api_key";
    private static final String MOVIE_DB_API_KEY = "0a08e38b874d0aa2d426ffc04357069d";
    private static final String MOVIE_DB_BASE_URL = "https://api.themoviedb.org/3/";

    public static TheMovieDbApi build() {
        return new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(MOVIE_DB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TheMovieDbApi.class);
    }

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(TheMovieDbApiBuiler::interceptRequest);
        return httpClient.build();
    }

    private static Response interceptRequest(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();
        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(API_KEY, MOVIE_DB_API_KEY)
                .build();

        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
