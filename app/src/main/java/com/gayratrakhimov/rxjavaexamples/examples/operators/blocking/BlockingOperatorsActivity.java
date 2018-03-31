package com.gayratrakhimov.rxjavaexamples.examples.operators.blocking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class BlockingOperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.interval(1, TimeUnit.SECONDS).take(5);

        // forEach vs blockingForEach
//        observable.forEach(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.d("RxJavaTag", "accept:"+o);
//            }
//        });
//        observable.blockingForEach(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.d("RxJavaTag", "accept:"+o);
//            }
//        });

        //blockingIterable
//        Iterable<Integer> iterable =observable.blockingIterable();
//        Iterator<Integer> iterator = iterable.iterator();
//        while(iterator.hasNext()){
//            Log.d("RxJavaTag", iterator.next()+"");
//        }

        // blockingNext
//        Iterable<Integer> iterable = observable.blockingNext();
//        Iterator<Integer> iterator = iterable.iterator();
//        while (iterator.hasNext()) {
//            Log.d("RxJavaTag", iterator.next() + "");
//        }

        // blockingLatest
//        Iterable<Integer> iterable = observable.blockingLatest();
//        Iterator<Integer> iterator = iterable.iterator();
//        while (iterator.hasNext()) {
//            Log.d("RxJavaTag", iterator.next() + "");
//        }

        Log.d("RxJavaTag", "Test");

    }
}
