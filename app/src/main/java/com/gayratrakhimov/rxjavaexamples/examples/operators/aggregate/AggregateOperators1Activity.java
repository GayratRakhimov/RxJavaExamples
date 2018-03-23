package com.gayratrakhimov.rxjavaexamples.examples.operators.aggregate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class AggregateOperators1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Observable observable1 = Observable.just(4, 3, 5, 2);
        final Observable observable2 = Observable.interval(1, TimeUnit.SECONDS);

        // concat
        Observable observable3 = Observable.merge(observable1, observable2);

        // countLong
        // reduce
        // collect
        // toList
        // toSortedList
        // toMap
        // toMultimap

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

        observable3.subscribe(observer);

    }

}
