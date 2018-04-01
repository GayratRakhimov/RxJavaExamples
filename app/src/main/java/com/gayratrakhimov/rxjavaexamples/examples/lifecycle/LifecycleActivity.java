package com.gayratrakhimov.rxjavaexamples.examples.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gayratrakhimov.rxjavaexamples.R;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
    }
}
