package com.gayratrakhimov.rxjavaexamples.examples.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class DisposableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable =
                Observable.just("Marshmallow", "Nougat", "Oreo")
                        .delay(3, TimeUnit.SECONDS);

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.d("RxJavaTag", "onNext: "+o);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxJavaTag", "onError");
            }

            @Override
            public void onComplete() {
                Log.d("RxJavaTag", "onComplete");
            }
        };

        // Observer subscribes to Observable to consume items
        Disposable disposable = observable.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept:"+o);
            }
        });

        disposable.dispose();

    }

}
