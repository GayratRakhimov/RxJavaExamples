package com.gayratrakhimov.rxjavaexamples.examples.observable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gayratrakhimov.rxjavaexamples.R;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public class SingleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        Single single = Single.just(1);
        single.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                Log.d("RxJavaTag", "accept: "+o);
            }
        });

    }

}
