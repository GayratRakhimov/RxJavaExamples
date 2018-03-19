package com.gayratrakhimov.rxjavaexamples.examples.introduction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class SetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Example: Quick win

        Observable.just("Hello RxJava!")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        Log.d("RxJavaTag", s);
                    }
                });

    }


}
