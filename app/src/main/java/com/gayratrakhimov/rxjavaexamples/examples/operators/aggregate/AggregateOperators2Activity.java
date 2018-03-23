package com.gayratrakhimov.rxjavaexamples.examples.operators.aggregate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class AggregateOperators2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
//        Maybe maybe = observable1.reduce(new BiFunction<Integer, Integer, Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) throws Exception {
//                return integer + integer2;
//            }
//        });
//        maybe.subscribe(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.d("RxJavaTag", "accept: " + o);
//            }
//        });

        // collect
//        Single single = observable1.collect(new Callable() {
//            @Override
//            public Object call() throws Exception {
//                return new ArrayList<Integer>();
//            }
//        }, new BiConsumer<ArrayList<Integer>, Integer>() {
//            @Override
//            public void accept(ArrayList<Integer> acc, Integer value) throws Exception {
//                acc.add(value);
//            }
//        });
//        single.subscribe(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.d("RxJavaTag", "accept: " + o);
//            }
//        });

        // toList
//        Single single = observable1.toList();
//        single.subscribe(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.d("RxJavaTag", "accept: " + o);
//            }
//        });

        // toSortedList
//        Single single = observable1.toSortedList();
//        single.subscribe(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.d("RxJavaTag", "accept: " + o);
//            }
//        });

        // toMap
        Single single = observable1.toMap(new Function<Integer, Object>() {
            @Override
            public Object apply(Integer integer) throws Exception {
                return null;
            }
        });

    }

}
