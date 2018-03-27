package com.gayratrakhimov.rxjavaexamples.examples.operators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.Callable;

import io.reactivex.Observable;


public class AsyncOperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.just(5,3,4,2);

        Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });

        // fromCallable
        // fromRunnable
        // runAsync

    }

}
