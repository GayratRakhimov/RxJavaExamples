package com.gayratrakhimov.rxjavaexamples.examples.operators.utility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UtilityOperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.just(5, 3, 3, 2);

        // materialize
        observable = observable.materialize();

        // dematerialize
        // timestamp
        // serialize
        // cache
        // observeOn
        // subscribeOn
        // doOnEach
        // doOnCompleted
        // doOnError
        // doOnTerminate
        // doOnSubscribe
        // doOnUnsubscribe
        // finallyDo
        // delay
        // delaySubscription
        // timeInterval
        // using
        // single
        // singleOrDefault
        // repeat
        // repeatWhen

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
