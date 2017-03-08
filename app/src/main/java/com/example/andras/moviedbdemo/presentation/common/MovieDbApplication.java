package com.example.andras.moviedbdemo.presentation.common;

import android.app.Application;

/**
 * Created by Andras_Nemeth on 2017. 03. 07..
 */

public class MovieDbApplication extends Application {

    public static MovieDbApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
