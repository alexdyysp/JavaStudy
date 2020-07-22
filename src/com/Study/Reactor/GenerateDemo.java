package com.Study.Reactor;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicLong;

public class GenerateDemo {
    public static void main(String[] args){
        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3*state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });
        flux.subscribe(System.out::println);

        Flux<String> fluxAtmoic = Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next("3 x " + i + " = " + 3*i);
                    if (i == 10) sink.complete();
                    return state;
                });
        fluxAtmoic.subscribe(System.out::println);

        /* 如果状态对象需要清理资源，可以使用 generate(Supplier<S>, BiFunction, Consumer<S>)
         这个签名方法来清理状态对象（译者注：Comsumer 在序列终止才被调用）。 */
        Flux<String> fluxConsumer = Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next("3 x " + i + " = " + 3*i);
                    if (i == 10) sink.complete();
                    return state;
                }, (state) -> System.out.println("state: " + state));
        fluxConsumer.subscribe(System.out::println);
    }
}
