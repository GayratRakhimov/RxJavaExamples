package com.gayratrakhimov.rxjavaexamples.examples.flowable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

public class BackpressureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                for (int i = 0; i < 100000; i++) {
                    emitter.onNext(i);
                }
            }
        });

        // MISSING
//        Flowable flowable = observable.toFlowable(BackpressureStrategy.MISSING);

        // DROP
//        Flowable flowable = observable.toFlowable(BackpressureStrategy.DROP);

        // LATEST
//        Flowable flowable = observable.toFlowable(BackpressureStrategy.LATEST);

        // BUFFER
        Flowable flowable = observable.toFlowable(BackpressureStrategy.BUFFER);

        flowable.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept:"+o);
            }
        });

    }
}
