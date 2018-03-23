package com.gayratrakhimov.rxjavaexamples.examples.operators.aggregate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gayratrakhimov.rxjavaexamples.R;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

public class AggregateOperators2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggregate_operators2);

        final Observable<Integer> observable1 = Observable.just(4, 3, 5, 2);

        // count
//        Single single = observable1.count();
//        single.subscribe(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.d("RxJavaTag", "accept: " + o);
//            }
//        });

        // reduce
        Maybe maybe = observable1.reduce(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });
        maybe.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept: " + o);
            }
        });


    }

}
