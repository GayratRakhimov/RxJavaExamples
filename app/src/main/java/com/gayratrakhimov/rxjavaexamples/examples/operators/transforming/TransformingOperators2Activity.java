package com.gayratrakhimov.rxjavaexamples.examples.operators.transforming;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gayratrakhimov.rxjavaexamples.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

public class TransformingOperators2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transforming_operators2);

        Observable observable = Observable.just(4, 3, 5, 2);

        // groupBy
        observable = observable.groupBy(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return (int) o % 2;
            }
        });

        Observer firstObserver = getFirstObserver();
        observable.subscribe(firstObserver);

    }

    private Observer getFirstObserver() {
        return new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "FirstObserver onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                GroupedObservable groupedObservable = (GroupedObservable) o;
                groupedObservable.subscribe(getSecondObserver(groupedObservable.getKey().toString()));
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxJavaTag", "FirstObserver onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("RxJavaTag", "FirstObserver onComplete");
            }
        };
    }

    @NonNull
    private Observer getSecondObserver(final String key) {
        return new Observer() {
                @Override
                public void onSubscribe(Disposable d) {
                    Log.d("RxJavaTag", "SecondObserver onSubscribe: key="+key);
                }

                @Override
                public void onNext(Object o) {
                    Log.d("RxJavaTag", "SecondObserver onNext: key="+key+"; item=" + o);
                }

                @Override
                public void onError(Throwable e) {
                    Log.d("RxJavaTag", "SecondObserver onError:" + e.toString());
                }

                @Override
                public void onComplete() {
                    Log.d("RxJavaTag", "SecondObserver onComplete: key="+key);
                }
            };
    }

}
