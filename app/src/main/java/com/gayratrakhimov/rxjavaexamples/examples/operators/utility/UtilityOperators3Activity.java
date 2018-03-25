package com.gayratrakhimov.rxjavaexamples.examples.operators.utility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class UtilityOperators3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.interval(1, TimeUnit.SECONDS);

        // doOnDispose
        observable = observable.doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Log.d("RxJavaTag", "doOnDispose");
            }
        });

        Disposable disposable = observable.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept:"+o);
            }
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        disposable.dispose();

    }

}
