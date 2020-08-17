package com.Study.Reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class SchedulersDemo {
    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 10)
                .publishOn(Schedulers.parallel())
                .subscribe(i -> {System.out.println(i++);},
                        error -> {System.out.println("error");},
                        ()->{System.out.println("Done");});


        Thread.sleep(2100);

        Flux.interval(Duration.ofMillis(250))
                .map(input -> {
                    if (input < 3) return "tick " + input;
                    throw new RuntimeException("boom");
                })
                .elapsed()
                .retry(1)
                .subscribe(System.out::println, System.err::println);

        Thread.sleep(2100);

        Flux.just("foo")
                .map(s -> { throw new IllegalArgumentException(s); })
                .subscribe(v -> System.out.println("GOT VALUE"),
                        e -> System.out.println("ERROR: " + e));

        System.out.println("DEMO: subscribeOn after publishOn");
        Flux.just("a", "b", "c") //this is where subscription triggers data production
                //this is influenced by subscribeOn
                .doOnNext(v -> System.out.println("before publishOn: " + Thread.currentThread().getName() + " " + v))
                .publishOn(Schedulers.elastic())
                //the rest is influenced by publishOn
                //.doOnNext(v -> System.out.println("after publishOn: " + Thread.currentThread().getName() + " " + v))
                .subscribeOn(Schedulers.parallel())
                .subscribe(v -> System.out.println("received " + v + " on " + Thread.currentThread().getName() + " " + v));

        Thread.sleep(5000);

    }
}
