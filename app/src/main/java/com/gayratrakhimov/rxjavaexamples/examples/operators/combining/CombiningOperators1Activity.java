package com.gayratrakhimov.rxjavaexamples.examples.operators.combining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;


public class CombiningOperators1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Observable observable1 = Observable.just(4, 3, 5, 2);
        final Observable observable2 = Observable.interval(1, TimeUnit.SECONDS);
        Observable observableError = Observable.error(new Throwable("Error happened"));

        // startWith
//        Observable observable3 = observable1.startWith(observable2);

        // merge #1
//        Observable observable3 = Observable.merge(observable1, observable2);

        // merge #2
//        Observable observable3 = observable1.mergeWith(observable2);

        // merge #3
//        Observable observable3 = Observable.merge(observableError, observable2);

        // mergeDelayError #1
//        Observable observable3 = Observable.mergeDelayError(observableError, observable1);

        // mergeDelayError #2
//        Observable observable3 = Observable.mergeDelayError(observableError, observable2);

        // zip
//        Observable observable3 = Observable.zip(observable1, observable2, new BiFunction() {
//            @Override
//            public Object apply(Object o, Object o2) throws Exception {
//                return o + " - " + o2;
//            }
//        });

        // combineLatest
        Observable observable3 = Observable.combineLatest(observable1, observable2, new BiFunction() {
            @Override
            public Object apply(Object o, Object o2) throws Exception {
                return o + " - " + o2;
            }
        });

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
