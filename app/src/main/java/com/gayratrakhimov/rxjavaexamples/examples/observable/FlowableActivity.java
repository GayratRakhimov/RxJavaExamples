package com.gayratrakhimov.rxjavaexamples.examples.observable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gayratrakhimov.rxjavaexamples.R;

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
        setContentView(R.layout.activity_flowable);

        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                for (int i = 0; i < 1000000; i++) {
                    emitter.onNext(i);
                }
            }
        });

        Flowable flowable = observable.toFlowable(BackpressureStrategy.MISSING);

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

        flowable.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept:"+o);
            }
        });
        
    }

}
