package com.gayratrakhimov.rxjavaexamples.examples.operators.aggregate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class AggregateOperators3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // toMap
//        Observable<Digit> digits = Observable.just(
//                new Digit(1, "One"),
//                new Digit(2, "Two"),
//                new Digit(3, "Three")
//        );
//
//        Single single = digits.toMap(new Function<Digit, Integer>() {
//            @Override
//            public Integer apply(Digit digit) throws Exception {
//                return digit.digit;
//            }
//        });
//
//        single.subscribe(new Consumer<Map<Integer, Digit>>() {
//            @Override
//            public void accept(Map<Integer, Digit> map) throws Exception {
//                Log.d("RxJavaTag", "accept: " + map.get(2).name);
//            }
//        });

        // toMultimap
        Observable<Digit> digits = Observable.just(
                new Digit(1, "One"),
                new Digit(2, "Two"),
                new Digit(3, "Three"),
                new Digit(1, "Uno")
        );

        Single single = digits.toMultimap(new Function<Digit, Integer>() {
            @Override
            public Integer apply(Digit digit) throws Exception {
                return digit.digit;
            }
        });

        single.subscribe(new Consumer<Map<Integer, List<Digit>>>() {
            @Override
            public void accept(Map<Integer, List<Digit>> map) throws Exception {
                for(Digit digit: map.get(1)){
                    Log.d("RxJavaTag", "accept: " + digit.name);
                }
            }
        });

    }

    class Digit {

        public final int digit;
        public final String name;

        public Digit(int digit, String name) {
            this.digit = digit;
            this.name = name;
        }

    }

}
