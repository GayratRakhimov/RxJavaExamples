package com.gayratrakhimov.rxjavaexamples.examples.schedulers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SchedulersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.just(5,3,4,2);

        final Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.d("RxJavaTag", "onNext: " + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxJavaTag", "onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("RxJavaTag", "onComplete");
            }
        };

//        // single
//        observable = observable.subscribeOn(Schedulers.single());
//
//        // trampoline
//        observable = observable.subscribeOn(Schedulers.trampoline());

//        // newThread
//        observable = observable.subscribeOn(Schedulers.newThread());

//        // io
//        observable = observable.subscribeOn(Schedulers.io());

//        // computation
//        observable = observable.subscribeOn(Schedulers.computation());

        // executor scheduler
//        final ExecutorService executor = Executors.newFixedThreadPool(10);
//        final Scheduler pooledScheduler = Schedulers.from(executor);
//        observable = observable.subscribeOn(pooledScheduler);

        // Android scheduler
//        observable = observable.subscribeOn(AndroidSchedulers.mainThread());

        observable.subscribe(observer);

    }

}
