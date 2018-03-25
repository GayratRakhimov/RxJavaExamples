package com.gayratrakhimov.rxjavaexamples.examples.operators.utility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class UtilityOperators2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.interval(1000, TimeUnit.MILLISECONDS).take(5);

        // cache
//        observable = observable.cache();
//
//        try {
//            observable.subscribe(new Consumer() {
//                @Override
//                public void accept(Object o) throws Exception {
//                    Log.d("RxJavaTag", "First:"+o);
//                }
//            });
//
//            Thread.sleep(7000);
//            observable.subscribe(new Consumer() {
//                @Override
//                public void accept(Object o) throws Exception {
//                    Log.d("RxJavaTag", "Second:"+o);
//                }
//            });
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }

}
