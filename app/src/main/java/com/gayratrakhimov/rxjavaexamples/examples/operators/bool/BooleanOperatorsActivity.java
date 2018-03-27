package com.gayratrakhimov.rxjavaexamples.examples.operators.bool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class BooleanOperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable1 = Observable.just(5, 3, 4, 2);

        // all
        Single single = observable1.all(new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) throws Exception {
                return i > 1;
            }
        });
        single.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept:"+o);
            }
        });

        // all
        // contains
        // exists
        // isEmpty
        // sequenceEqual

    }
}
