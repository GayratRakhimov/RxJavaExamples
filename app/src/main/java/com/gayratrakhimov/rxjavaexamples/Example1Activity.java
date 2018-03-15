package com.gayratrakhimov.rxjavaexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Example1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        Observable.just("Hello RxJava!")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        Log.d("RxJavaTag", s);
                    }
                });

    }


}
