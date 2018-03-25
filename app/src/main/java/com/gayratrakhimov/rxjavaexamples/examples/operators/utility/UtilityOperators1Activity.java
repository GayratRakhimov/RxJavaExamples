package com.gayratrakhimov.rxjavaexamples.examples.operators.utility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UtilityOperators1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable observable = Observable.just(5, 3, 4, 2);

        // materialize
//         observable = observable.materialize();

        // dematerialize
//        observable = observable.dematerialize();

        // timestamp
//         observable = observable.timestamp();

        // timeInterval
//        observable = observable.timeInterval();

        // doOnEach:
//        observable = observable.doOnEach(new Consumer<Notification>() {
//            @Override
//            public void accept(Notification notification) throws Exception {
//                Log.d("RxJavaTag", "doOnEach:"+notification.getValue());
//            }
//        });

        // doOnCompleted
//        observable = observable.doOnComplete(new Action() {
//            @Override
//            public void run() throws Exception {
//                Log.d("RxJavaTag", "doOnComplete");
//            }
//        });

        // doOnError
//        observable = observable.doOnError(new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                Log.d("RxJavaTag", "doOnError");
//            }
//        });

        // doOnTerminate
//        observable = observable.doOnTerminate(new Action() {
//            @Override
//            public void run() throws Exception {
//                Log.d("RxJavaTag", "doOnTerminate");
//            }
//        });

        // doOnSubscribe
//        observable = observable.doOnSubscribe(new Consumer<Disposable>() {
//            @Override
//            public void accept(Disposable disposable) throws Exception {
//                Log.d("RxJavaTag", "doOnSubscribe");
//            }
//        });

        // doFinally
//        observable = observable.doFinally(new Action() {
//            @Override
//            public void run() throws Exception {
//                Log.d("RxJavaTag", "doFinally");
//            }
//        });

        // using
//        observable = Observable.using(new Callable() {
//            @Override
//            public Object call() throws Exception {
//                String resource = "MyResource";
//                System.out.println("Leased: " + resource);
//                return resource;
//            }
//        }, new Function() {
//            @Override
//            public Object apply(Object o) throws Exception {
//                return Observable.create(new ObservableOnSubscribe<String>() {
//                    @Override
//                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                        emitter.onComplete();
//                    }
//                });
//            }
//        }, new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Log.d("RxJavaTag", "Disposed:" + o);
//            }
//        });

        // repeat
//        observable = observable.repeat(3);

        // repeatWhen
//        observable = observable.repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
//                return objectObservable.delay(3, TimeUnit.SECONDS);
//            }
//        });

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
