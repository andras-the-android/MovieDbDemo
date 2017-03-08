package com.example.andras.moviedbdemo.logic.network;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andras_Nemeth on 2017. 03. 02..
 */

public class TheMovieDbApiBuilder {

    private static final String API_KEY = "api_key";
    private static final String MOVIE_DB_API_KEY = "0a08e38b874d0aa2d426ffc04357069d";
    private static final String MOVIE_DB_BASE_URL = "https://api.themoviedb.org/3/";
    private static final String MOVIE_DB_BASE_URL_IMAGE_ORIGINAL = "https://image.tmdb.org/t/p/original/";
    private static final String MOVIE_DB_BASE_URL_IMAGE_THUMBNAIL = "https://image.tmdb.org/t/p/w185/";

    public TheMovieDbApi build() {
        return new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(MOVIE_DB_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TheMovieDbApi.class);
    }

    public Picasso getPicasso(Context context) {
        return new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(getOkHttpClient()))
                .build();
    }
    public String getBaseImageUrlForOriginalSize() {
        return MOVIE_DB_BASE_URL_IMAGE_ORIGINAL;
    }

    public String getBaseImageUrlForThumbnailSize() {
        return MOVIE_DB_BASE_URL_IMAGE_THUMBNAIL;
    }


    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(TheMovieDbApiBuilder::interceptRequest);
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
