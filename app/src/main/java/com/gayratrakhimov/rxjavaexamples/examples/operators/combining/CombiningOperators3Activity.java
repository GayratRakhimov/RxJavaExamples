package com.gayratrakhimov.rxjavaexamples.examples.operators.combining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class CombiningOperators3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // switchOnNext

        Observable observable1 = Observable.interval(5, TimeUnit.SECONDS)
                .map(new Function<Long, Observable>() {
                    @Override
                    public Observable apply(Long aLong) throws Exception {
                        return Observable.interval(1, TimeUnit.SECONDS);
                    }
                });

        Observable observable2 = Observable.switchOnNext(observable1);

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

        observable2.subscribe(observer);

    }

}
