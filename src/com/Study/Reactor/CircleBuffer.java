package com.Study.Reactor;

import org.reactivestreams.Processor;
import reactor.core.processor.RingBufferProcessor;
import reactor.rx.Stream;
import reactor.rx.Streams;


public class CircleBuffer {
    public static void main(String[] args){
        Processor<Integer, Integer> p = RingBufferProcessor.create("test", 32); //*1
        Stream<Integer> s = Streams.wrap(p); //*2

        s.consume(i -> System.out.println(Thread.currentThread() + " data=" + i)); //*3
        s.consume(i -> System.out.println(Thread.currentThread() + " data=" + i)); //*4
        s.consume(i -> System.out.println(Thread.currentThread() + " data=" + i)); //*5

        s.subscribe(p); //*
    }
}
