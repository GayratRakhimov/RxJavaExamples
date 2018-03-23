package com.gayratrakhimov.rxjavaexamples.examples.operators.aggregate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gayratrakhimov.rxjavaexamples.R;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public class AggregateOperators2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggregate_operators2);

        final Observable observable1 = Observable.just(4, 3, 5, 2);

        // count
        Single single = observable1.count();
        single.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept: " + o);
            }
        });

    }

}
