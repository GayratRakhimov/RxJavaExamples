package com.gayratrakhimov.rxjavaexamples.examples.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gayratrakhimov.rxjavaexamples.R;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakActivity extends AppCompatActivity {

    private static final List<MemoryLeakActivity> INSTANCES = new ArrayList<>();

    private String[] bigArray = new String[10000000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_leak);

        bigArray[0] = "test";
        INSTANCES.add(this);

        Log.d("RxJavaTag", "Activity created");

    }

    @Override
    protected void onDestroy() {
        Log.d("RxJavaTag", "Activity destroyed");
        super.onDestroy();
    }

}
