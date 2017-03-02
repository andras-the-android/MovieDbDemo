package com.example.andras.moviedbdemo.modules.movies.list.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.andras.moviedbdemo.R;
import com.example.andras.moviedbdemo.logic.data.LoadPopularMoviesResponse;
import com.example.andras.moviedbdemo.logic.di.TheMovieDbComponent;
import com.example.andras.moviedbdemo.logic.interactor.TheMovieDbInteractor;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieList extends AppCompatActivity {

    private static final String TAG = "MovieList";

    @Inject
    TheMovieDbInteractor theMovieDbInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TheMovieDbComponent.Get.component().inject(this);
        setContentView(R.layout.activity_movie_list);
        TextView textView = (TextView) findViewById(R.id.text);
        theMovieDbInteractor.loadPopularMovies(1, new Callback<LoadPopularMoviesResponse>() {
            @Override
            public void onResponse(Call<LoadPopularMoviesResponse> call, Response<LoadPopularMoviesResponse> response) {
                textView.setText(response.body().getMovies().get(0).getOriginalTitle());
            }

            @Override
            public void onFailure(Call<LoadPopularMoviesResponse> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
            }
        });
    }
}
