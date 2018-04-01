package com.gayratrakhimov.rxjavaexamples.examples.flowable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

public class FlowableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                for (int i = 0; i < 1000000; i++) {
                    emitter.onNext(i);
                }
            }
        });

        //        Observer observer = new Observer() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d("RxJavaTag", "onSubscribe");
//            }
//
//            @Override
//            public void onNext(Object o) {
//                Log.d("RxJavaTag", "onNext: "+o);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d("RxJavaTag", "onError");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d("RxJavaTag", "onComplete");
//            }
//        };

//        observable.subscribe(observer);

        Flowable flowable = observable.toFlowable(BackpressureStrategy.MISSING);

        flowable.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept:"+o);
            }
        });
        
    }

}
