package com.gayratrakhimov.rxjavaexamples.examples.operators.filtering;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class FilteringOperators3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.interval(2, TimeUnit.SECONDS);

        // sample
//        observable = observable.sample(3, TimeUnit.SECONDS);

        // throttleLast
//        observable = observable.throttleLast(3, TimeUnit.SECONDS);

        // throttleFirst
//        observable = observable.throttleFirst(3, TimeUnit.SECONDS);

        // sample
//        observable = observable.throttleLast(3, TimeUnit.SECONDS);

        // debounce or throttleWithTimeout
//        observable = Observable.concat(
//                Observable.interval(1, TimeUnit.SECONDS).take(3),
//                Observable.interval(3, TimeUnit.SECONDS).take(3));
//        observable = observable.debounce(2, TimeUnit.SECONDS);

        // timeout
//        observable = Observable.concat(
//                Observable.interval(1, TimeUnit.SECONDS).take(3),
//                Observable.interval(3, TimeUnit.SECONDS).take(3));
//        observable = observable.timeout(2, TimeUnit.SECONDS);

        final Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.d("RxJavaTag", "onNext: " + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxJavaTag", "onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("RxJavaTag", "onComplete");
            }
        };

        observable.subscribe(observer);

    }

}
