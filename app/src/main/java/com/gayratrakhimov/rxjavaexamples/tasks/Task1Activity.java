package com.gayratrakhimov.rxjavaexamples.tasks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gayratrakhimov.rxjavaexamples.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Task1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        // Task: Observable & Observer

        Observable observable = Observable.just(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        );

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "Emitting weekdays starts");
            }

            @Override
            public void onNext(String s) {
                Log.d("RxJavaTag", s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("RxJavaTag", "Could not get weekday: "+ e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("RxJavaTag", "Emitting weekdays complete");
            }
        };

    }

}
