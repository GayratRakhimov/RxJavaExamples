package com.gayratrakhimov.rxjavaexamples.examples.operators.filtering;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public class FilteringOperators2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable1 = Observable.just(5, 3, 2, 4);

        Single single = observable1.last(6);
        single.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept: " + o);
            }
        });

    }

}
