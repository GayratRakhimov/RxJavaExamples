package com.gayratrakhimov.rxjavaexamples.examples.operators.transforming;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TransformingOperators1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.just(5, 3, 2, 4);

        // map
//        observable = observable.map(new Function() {
//            @Override
//            public Object apply(Object o) throws Exception {
//                return (int) o * 5;
//            }
//        });

        // flatMapIterable
//        observable = observable.flatMapIterable(new Function() {
//            @Override
//            public Object apply(Object o) throws Exception {
//                ArrayList<Integer> numbers = new ArrayList<>();
//                for (int i = 0; i < (int) o; i++) {
//                    numbers.add(i + 1);
//                }
//                return numbers;
//            }
//        });

        // flatMap
//        observable = observable.flatMap(new Function() {
//            @Override
//            public Object apply(Object o) throws Exception {
//                return Observable.range(1, (int) o);
//            }
//        });

        // flatMap
//        observable = observable.flatMap(new Function() {
//            @Override
//            public Object apply(final Object num) throws Exception {
//                Observable observableTimer = Observable.timer((int) num, TimeUnit.SECONDS);
//                observableTimer = observableTimer.map(new Function() {
//                    @Override
//                    public Object apply(Object o) throws Exception {
//                        return num + " seconds elapsed";
//                    }
//                });
//                return observableTimer;
//            }
//        });

        // concatMap
//        observable = observable.concatMap(new Function() {
//            @Override
//            public Object apply(final Object num) throws Exception {
//                Observable observableTimer = Observable.timer((int) num, TimeUnit.SECONDS);
//                observableTimer = observableTimer.map(new Function() {
//                    @Override
//                    public Object apply(Object o) throws Exception {
//                        return num + " seconds elapsed";
//                    }
//                });
//                return observableTimer;
//            }
//        });

        // switchMap
//        observable = observable.switchMap(new Function() {
//            @Override
//            public Object apply(final Object num) throws Exception {
//                Observable observableTimer = Observable.timer((int) num, TimeUnit.SECONDS);
//                observableTimer = observableTimer.map(new Function() {
//                    @Override
//                    public Object apply(Object o) throws Exception {
//                        return num + " seconds elapsed";
//                    }
//                });
//                return observableTimer;
//            }
//        });

        // scan
//        observable = observable.scan(new BiFunction() {
//            @Override
//            public Object apply(Object o, Object o2) throws Exception {
//                return (int) o * (int) o2;
//            }
//        });

        // buffer
//        observable = Observable.interval(1, TimeUnit.SECONDS).buffer(3);

        final Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("RxJavaTag", "onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.d("RxJavaTag", "onNext: " + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxJavaTag", "onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("RxJavaTag", "onComplete");
            }
        };

        observable.subscribe(observer);

    }

}
