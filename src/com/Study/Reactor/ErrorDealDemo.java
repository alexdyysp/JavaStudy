package com.Study.Reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class ErrorDealDemo {

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
    }
}
