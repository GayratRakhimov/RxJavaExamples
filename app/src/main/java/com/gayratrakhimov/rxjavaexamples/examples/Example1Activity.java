package com.gayratrakhimov.rxjavaexamples.examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gayratrakhimov.rxjavaexamples.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Example1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        // Example: Observable & Observer

        // Observable - emits items
        // Observer - consumes items

        Observable observable = Observable.just("Marshmallow", "Nougat", "Oreo");
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.d("RxJavaTag", "onNext:"+o);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxJavaTag", "onError");
            }

            @Override
            public void onComplete() {
                Log.d("RxJavaTag", "onComplete");
            }
        };

        // Observer subscribes to Observable
        observable.subscribe(observer);

    }

}
