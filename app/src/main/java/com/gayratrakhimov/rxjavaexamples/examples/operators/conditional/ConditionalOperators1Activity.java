package com.gayratrakhimov.rxjavaexamples.examples.operators.conditional;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ConditionalOperators1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Observable observable1 = Observable.just(4, 3, 5, 2);
        final Observable observable2 = Observable.interval(1, TimeUnit.SECONDS);

        // amb
//        Observable observable3 = observable1.ambWith(observable2);

        // defaultIfEmpty
//        Observable observableEmpty = Observable.empty();
//        Observable observable3 = observableEmpty.defaultIfEmpty(6);

        // skipWhile
//        Observable observable3 = observable1.skipWhile(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer i) throws Exception {
//                return i < 5;
//            }
//        });

        // takeWhile
//        Observable observable3 = observable1.takeWhile(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer i) throws Exception {
//                return i < 5;
//            }
//        });

        // skipUntil
//        Observable observable3 = observable2.skipUntil(observable1.delay(3, TimeUnit.SECONDS));

        // takeUntil
        Observable observable3 = observable2.takeUntil(observable1.delay(3, TimeUnit.SECONDS));

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
