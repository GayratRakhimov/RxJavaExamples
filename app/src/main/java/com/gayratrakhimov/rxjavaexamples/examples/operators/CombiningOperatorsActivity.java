package com.gayratrakhimov.rxjavaexamples.examples.operators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;


public class CombiningOperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable observable2 = Observable.just(4, 3, 5, 2);

        // zip
        Observable observable3 = Observable.zip(observable1, observable2, new BiFunction() {
            @Override
            public Object apply(Object o, Object o2) throws Exception {
                return o + " - " + o2;
            }
        });

        // startWith

        // merge
        // mergeDelayError
        // and, then, when
        // combineLatest
        // join
        // groupJoin
        // switchOnNext

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
