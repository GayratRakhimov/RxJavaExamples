package com.gayratrakhimov.rxjavaexamples.examples.operators.transforming;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.UnicastSubject;

public class TransformingOperators3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.interval(1, TimeUnit.SECONDS);

        // window
        observable = observable.window(3);

        Observer firstObserver = getFirstObserver();
        observable.subscribe(firstObserver);

    }

    private Observer getFirstObserver() {
        return new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "FirstObserver onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                UnicastSubject unicastSubject = (UnicastSubject) o;
                unicastSubject.subscribe(getSecondObserver());
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxJavaTag", "FirstObserver onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("RxJavaTag", "FirstObserver onComplete");
            }
        };
    }

    @NonNull
    private Observer getSecondObserver() {
        return new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "SecondObserver onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.d("RxJavaTag", "SecondObserver onNext: " + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxJavaTag", "SecondObserver onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("RxJavaTag", "SecondObserver onComplete");
            }
        };
    }

}
