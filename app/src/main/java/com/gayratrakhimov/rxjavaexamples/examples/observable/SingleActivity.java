package com.gayratrakhimov.rxjavaexamples.examples.observable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class SingleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Single single = Single.just(1);

        SingleObserver observer = new SingleObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "onSubscribe: "+d);
            }

            @Override
            public void onSuccess(Object o) {
                Log.d("RxJavaTag", "onSuccess: "+o);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxJavaTag", "onError: "+e);
            }
        };

        single.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept: "+o);
            }
        });

    }

}
