package com.Study.Reactor;

import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

public class ErrorDealDemo {


    public String convert(int i) throws IOException {
        if (i > 3) {
            throw new IOException("boom " + i);
        }
        return "OK " + i;
    }

    public static void main(String[] args) throws InterruptedException {
        Flux<String> flux =
                Flux.interval(Duration.ofMillis(250))
                        .map(input -> {
                            if (input < 3) return "tick " + input;
                            throw new RuntimeException("boom");
                        })
                        .onErrorReturn("Uh oh");

        flux.subscribe(System.out::println);
        Thread.sleep(2100);

        /*
        using = try
         */
        AtomicBoolean isDisposed = new AtomicBoolean();
        Disposable disposableInstance = new Disposable() {
            @Override
            public void dispose() {
                isDisposed.set(true);
            }

            @Override
            public String toString() {
                return "DISPOSABLE";
            }
        };

        Flux<String> fluxDispose =
                Flux.using(
                        () -> disposableInstance,
                        disposable -> Flux.just(disposable.toString()),
                        Disposable::dispose
                );

        fluxDispose.subscribe(System.out::println);

        // doFinally = finally
        LongAdder statsCancel = new LongAdder();

        Flux<String> fluxdoFinally =
                Flux.just("foo", "bar")
                        .doFinally(type -> {
                            if (type == SignalType.CANCEL)
                                statsCancel.increment();
                        })
                        .take(2);
        fluxdoFinally.subscribe(System.out::println);
        System.out.println(statsCancel.sum());

        // retryWhen : “高配版”的 retry
        Flux<String> fluxretryWhen = Flux
                .<String>error(new IllegalArgumentException())
                .doOnError(System.out::println)
                .retryWhen(companion -> companion.take(3)); // = retry(3)
        fluxretryWhen.subscribe(System.out::println);

        /*Flux<String> fluxretryWhen2 =
                Flux.<String>error(new IllegalArgumentException())
                        .retryWhen(companion -> companion
                                .zipWith(Flux.range(1, 4),
                                        (error, index) -> {
                                            if (index < 4) return index;
                                            else throw Exceptions.propagate(error);
                                        })
                        );
        fluxretryWhen2.subscribe(System.out::println);*/

        // 自带一些错误处理方式
        Flux.just("foo")
                .map(s -> { throw new IllegalArgumentException(s); })
                .subscribe(v -> System.out.println("GOT VALUE"),
                        e -> System.out.println("ERROR: " + e));


        /**
         * 受检查异常，如OutofMemory
         */
        ErrorDealDemo errorDealDemo = new ErrorDealDemo();
        Flux<String> converted = Flux
                .range(1, 10)
                .map(i -> {
                    try { return errorDealDemo.convert(i); }
                    catch (IOException e) { throw Exceptions.propagate(e); }
                });

        //converted.subscribe(System.out::println);

        // 转化成io异常
        converted.subscribe(
                v -> System.out.println("RECEIVED: " + v),
                e -> {
                    if (Exceptions.unwrap(e) instanceof IOException) {
                        System.out.println("Something bad happened with I/O");
                    } else {
                        System.out.println("Something bad happened");
                    }
                }
        );

    }
}
