package com.example.andras.moviedbdemo.modules.movies.list.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.andras.moviedbdemo.R;
import com.example.andras.moviedbdemo.logic.data.LoadPopularMoviesResponse;
import com.example.andras.moviedbdemo.logic.data.Movie;
import com.example.andras.moviedbdemo.logic.di.TheMovieDbComponent;
import com.example.andras.moviedbdemo.logic.interactor.TheMovieDbInteractor;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        theMovieDbInteractor.loadPopularMovies(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(new Observer<List<Movie>>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getMessage(), e);
                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        textView.setText(movies.get(0).getOriginalTitle());
                    }
                });
    }
}
