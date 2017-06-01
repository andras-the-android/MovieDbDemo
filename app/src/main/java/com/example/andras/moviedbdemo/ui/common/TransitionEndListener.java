package com.example.andras.moviedbdemo.ui.common;


import android.transition.Transition;

import com.annimon.stream.function.Consumer;

public class TransitionEndListener implements Transition.TransitionListener{

    private Consumer<Transition> callback;

    public TransitionEndListener(Consumer<Transition> callback) {
        this.callback = callback;
    }

    @Override
    public void onTransitionStart(Transition transition) {
    }

    @Override
    public void onTransitionEnd(Transition transition) {
        callback.accept(transition);
    }

    @Override
    public void onTransitionCancel(Transition transition) {
    }

    @Override
    public void onTransitionPause(Transition transition) {
    }

    @Override
    public void onTransitionResume(Transition transition) {
    }
}
