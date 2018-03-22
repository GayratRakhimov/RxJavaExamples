package com.gayratrakhimov.rxjavaexamples.examples.operators.combining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class CombiningOperators2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // example is taken from here:
        // https://github.com/Froussios/Intro-To-RxJava/blob/master/Part%204%20-%20Concurrency/3.%20Sequences%20of%20coincidence.md

        Observable<String> left =
                Observable.interval(4, TimeUnit.SECONDS)
                        .map(new Function<Long, String>() {
                            @Override
                            public String apply(Long aLong) throws Exception {
                                return "L" + aLong;
                            }
                        });

        Observable<String> right =
                Observable.interval(3, TimeUnit.SECONDS)
                        .map(new Function<Long, String>() {
                            @Override
                            public String apply(Long aLong) throws Exception {
                                return "R" + aLong;
                            }
                        });

        // join
//        Observable observableResult = left.join(right,
//                new Function<String, ObservableSource<Long>>() {
//                    @Override
//                    public ObservableSource<Long> apply(String s) throws Exception {
//                        return Observable.timer(2, TimeUnit.SECONDS);
//                    }
//                },
//                new Function<String, ObservableSource<Long>>() {
//                    @Override
//                    public ObservableSource<Long> apply(String s) throws Exception {
//                        return Observable.timer(1, TimeUnit.SECONDS);
//                    }
//                },
//                new BiFunction<String, String, Object>() {
//                    @Override
//                    public Object apply(String l, String r) throws Exception {
//                        return l + " - " + r;
//                    }
//                })
//                .take(10);

        // groupJoin
        Observable observableResult = left.groupJoin(right,
                new Function<String, ObservableSource<Long>>() {
                    @Override
                    public ObservableSource<Long> apply(String s) throws Exception {
                        return Observable.timer(2, TimeUnit.SECONDS);
                    }
                },
                new Function<String, ObservableSource<Long>>() {
                    @Override
                    public ObservableSource<Long> apply(String s) throws Exception {
                        return Observable.timer(1, TimeUnit.SECONDS);
                    }
                },
                new BiFunction<String, Observable<String>, Object>() {
                    @Override
                    public Object apply(String l, Observable<String> rs) throws Exception {
                        return rs.toList().subscribe(new Consumer<List<String>>() {
                            @Override
                            public void accept(List<String> strings) throws Exception {
                                Log.d("RxJavaTag", strings.toArray().toString());
                            }
                        });
                    }
                })
                .take(10);

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

        observableResult.subscribe(observer);

    }

}
