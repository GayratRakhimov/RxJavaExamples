package com.gayratrakhimov.rxjavaexamples.examples;

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


public class Example2Activity extends AppCompatActivity {

    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

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
        Observable observableJust = Observable.just(1, 2, 3);
        //observableJust.subscribe(observer);

        // Observable created using range() method
        Observable observableRange = Observable.range(1, 10);
        //observableRange.subscribe(observer);

        // Observable created using interval() method
        Observable observableInterval = Observable.interval(1, TimeUnit.SECONDS);
        //observableInterval.subscribe(observer);

        // Observable created using timer() method
        Observable observableTimer = Observable.timer(3, TimeUnit.SECONDS);
        //observableTimer.subscribe(observer);

        // Observable created using create() method
        Observable observableCreate = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("Marshmallow");
                emitter.onNext("Nougat");
                emitter.onNext("Oreo");
                emitter.onError(new Throwable("Next version is not available"));
                emitter.onComplete();
            }
        });
        //observableCreate.subscribe(observer);

        // Observable created using empty() method
        Observable observableEmpty = Observable.empty();
        // observableEmpty.subscribe(observer);

        // Observable created using never() method
        Observable observableNever = Observable.never();
        // observableNever.subscribe(observer);

        // Observable created using error() method
        Observable observableError = Observable.error(new Throwable("Next version is not available"));
        // observableError.subscribe(observer);

        // Observable created using defer() method
        Observable observableDefer = Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                return Observable.just(name);
            }
        });
        name = "Gayrat";
        //observableDefer.subscribe(observer);

    }

}
