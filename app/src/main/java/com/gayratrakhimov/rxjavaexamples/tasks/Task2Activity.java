package com.gayratrakhimov.rxjavaexamples.tasks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gayratrakhimov.rxjavaexamples.R;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Task2Activity extends AppCompatActivity {

    int x = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        Observer observer = new Observer() {
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

        // Observable created using just() method
        Observable observableJust = Observable.just(4, 5, 6, 7, 8);
        // observableJust.subscribe(observer);

        // Observable created using range() method
        Observable observableRange = Observable.range(4, 5);
        // observableRange.subscribe(observer);

        // Observable created using interval() method
        Observable observableInterval = Observable.interval(3, TimeUnit.SECONDS);
        // observableInterval.subscribe(observer);

        // Observable created using timer() method
        Observable observableTimer = Observable.timer(5, TimeUnit.SECONDS);
        // observableTimer.subscribe(observer);

        // Observable created using create() method
        Observable observableCreate = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(6);
                emitter.onNext(7);
                emitter.onNext(8);
                emitter.onError(new Throwable("Next version is not available"));
                emitter.onComplete();
            }
        });
        // observableCreate.subscribe(observer);

        // Observable created using defer() method
        Observable observableDefer = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(x);
            }
        });
        x = x + 3;
        observableDefer.subscribe(observer);

    }
}
