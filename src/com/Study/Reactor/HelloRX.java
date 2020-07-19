package com.Study.Reactor;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HelloRX {
    public static void main(String[] args){
        // 事件源
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("hello");
                observableEmitter.onNext("www");
                observableEmitter.onNext("Let's start");
            }
        });

        // 消费源
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(Thread.currentThread().getName() + "---consumer---" + s);

            }
        };

        //observable.subscribe(consumer);
        observable.observeOn(Schedulers.newThread()).subscribe(consumer);

        for(;;);

    }
}
