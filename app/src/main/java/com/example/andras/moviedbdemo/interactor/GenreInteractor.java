package com.example.andras.moviedbdemo.interactor;


import android.util.Log;
import android.util.SparseArray;

import com.annimon.stream.Stream;
import com.example.andras.moviedbdemo.data.tmdb.TmdbGenre;
import com.example.andras.moviedbdemo.data.tmdb.TmdbGenreResponse;
import com.example.andras.moviedbdemo.network.TheMovieDbApi;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class GenreInteractor {

    private static final String TAG = "GenreInteractor";

    private SparseArray<String> movieGenres;
    private SparseArray<String> tvGenres;
    private TheMovieDbApi api;

    public GenreInteractor(TheMovieDbApi api) {
        this.api = api;
    }

    /**
     * This method contains synchronous network communication. Never call from main thread!
     */
    public String concatGenresByIdForMovies(List<Integer> ids) {
        if (movieGenres == null) {
            loadMovieGenres();
            if (movieGenres.size() == 0) {
                return "";
            }
        }
        return concat(ids, movieGenres);
    }

    /**
     * This method contains synchronous network communication. Never call from main thread!
     */
    public String concatGenresByIdForTvShows(List<Integer> ids) {
        if (tvGenres == null) {
            loadTvGenres();
            if (tvGenres.size() == 0) {
                return "";
            }
        }
        return concat(ids, tvGenres);
    }

    private String concat(List<Integer> ids, SparseArray<String> genres) {
        StringBuilder sb = new StringBuilder();
        for (Integer id : ids) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(genres.get(id));
        }
        return sb.toString();
    }

    private void loadMovieGenres() {
        movieGenres = new SparseArray<>();
        loadGenre(movieGenres, api.getGenresForMovies());
    }

    private void loadTvGenres() {
        tvGenres = new SparseArray<>();
        loadGenre(tvGenres, api.getGenresForTvShows());
    }

    private void loadGenre(SparseArray<String> genres, Call<TmdbGenreResponse> call) {
        try {
            tryLoadGenre(genres, call);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    private void tryLoadGenre(SparseArray<String> genres, Call<TmdbGenreResponse> call) throws IOException {
        Stream.of(call.execute().body().getGenres())
                .forEach(tmdbGenre -> genres.append(tmdbGenre.getId(), tmdbGenre.getName()));
    }
}
