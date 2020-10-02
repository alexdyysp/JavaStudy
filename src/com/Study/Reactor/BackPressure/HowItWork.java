package com.Study.Reactor.BackPressure;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @Author daiyuanyang
 * @Date 2020/9/20 12:08 上午
 */
public class HowItWork {

    @Test
    public void test1(){
        //Integer end = 10;
        Integer end = Integer.MAX_VALUE;

        Flux.range(1, end)
                .log()
                .limitRate(1)
                .concatMap(x -> Mono.delay(Duration.ofMillis(100)), 1) // simulate that processing takes time
                .blockLast();
    }

    @Test
    public void test2(){
        Flux.interval(Duration.ofMillis(1))
                .log()
                .concatMap(x -> Mono.delay(Duration.ofMillis(100)))
                .blockLast();
    }

    @Test
    public void test3(){
        Flux.range(0,1).interval(Duration.ofMillis(1))
                .onBackpressureDrop()
                .concatMap(a -> Mono.delay(Duration.ofMillis(100)).thenReturn(a))
                .doOnNext(a -> System.out.println("Element kept by consumer: " + a))
                .blockLast();
    }
}
