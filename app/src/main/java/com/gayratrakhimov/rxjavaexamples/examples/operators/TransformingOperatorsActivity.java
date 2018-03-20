package com.gayratrakhimov.rxjavaexamples.examples.operators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TransformingOperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.just("Marshmallow", "Nougat", "Oreo");

        Observer observer = new Observer() {
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

        // map
//        observable = observable.map(new Function() {
//            @Override
//            public Object apply(Object o) throws Exception {
//                return "Android " + o;
//            }
//        });

        // flatMap


        // flatMap, concatMap, flatMapIterable
        // switchMap
        // scan
        // groupBy
        // buffer
        // window
        // cast

        observable.subscribe(observer);

    }

}
