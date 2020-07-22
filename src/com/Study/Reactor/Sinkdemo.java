package com.Study.Reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class Sinkdemo {
    public static void main(String[] args){

        Flux.just(1, 2, 3, 4, 5, 6).subscribe(
                System.out::print);

        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        seq1.subscribe(System.out::println, System.err::println, ()->System.out.println("seq1 Completed!"));

        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        Flux<String> seq2 = Flux.fromIterable(iterable);
        seq2.subscribe(System.out::println, System.err::println, ()->System.out.println("seq2 Completed!"));

        // Factory create Flux / Mono
        Mono<String> noData = Mono.empty();

        Mono<String> data = Mono.just("foo");

        Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 3);


        Flux<Integer> ints = Flux.range(1, 3);
        ints.subscribe(System.out::print);
        ints.subscribe(i -> System.out.print(i));

        System.out.println("Flux<Integer> ints2: ");
        Flux<Integer> ints2 = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) return i;
                    throw new RuntimeException("Got to 4");
                });
        // 错误信号与完成信号是互斥独立的
        ints2.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error: " + error),
                ()->{System.out.println("Done");});

        System.out.println("SampleSubscriber<Integer> ss: ");
        SampleSubscriber<Integer> ss = new SampleSubscriber<Integer>();
        Flux<Integer> ints3 = Flux.range(1, 4);
        ints3.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error " + error),
                () -> {System.out.println("Done");},
                s -> ss.request(10));
        ints3.subscribe(ss);



    }
}
