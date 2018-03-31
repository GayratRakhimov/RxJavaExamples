package com.gayratrakhimov.rxjavaexamples.examples.operators.blocking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class BlockingOperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.interval(1, TimeUnit.SECONDS).take(10);
        
        // forEach
//        observable.forEach(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.d("RxJavaTag", "accept:"+o);
//            }
//        });

        observable.blockingForEach(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept:"+o);
            }
        });

        Log.d("RxJavaTag", "Test");

//        Iterable<Integer> iterable =observable1.blockingIterable();
//        Iterator<Integer> iterator = iterable.iterator();
//        while(iterator.hasNext()){
//            Log.d("RxJavaTag", iterator.next()+"");
//        }

        // next
        // latest
        // single
        // singleOrDefault
        // toFuture
        // toIterable
        // getIterator

    }
}
