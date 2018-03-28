package com.gayratrakhimov.rxjavaexamples.examples.operators.blocking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Iterator;

import io.reactivex.Observable;

public class BlockingOperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable1 = Observable.just(5,3,4,2);
        
        // forEach
//        observable1.forEach(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.d("RxJavaTag", "accept:"+o);
//            }
//        });

        Iterable<Integer> iterable =observable1.blockingIterable();
        Iterator<Integer> iterator = iterable.iterator();
        while(iterator.hasNext()){
            Log.d("RxJavaTag", iterator.next()+"");
        }

        // next
        // latest
        // single
        // singleOrDefault
        // toFuture
        // toIterable
        // getIterator

    }
}
