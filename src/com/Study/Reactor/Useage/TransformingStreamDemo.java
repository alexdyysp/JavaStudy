package com.Study.Reactor.Useage;

import org.apache.tools.ant.taskdefs.Get;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Date;
import java.util.Iterator;


public class TransformingStreamDemo {

    public Mono<String> toUpperCase(Mono<String> mono){
        return mono.map(String::toUpperCase);
    }

    Flux<String> toUpperCaseFlux(Flux<String> flux){
        return flux.flatMap(s -> Mono.just(s.toUpperCase()));
    }

    Flux<String> asyncToUpperCase(Flux<String> flux){
        return flux.flatMap(s -> Mono.defer(() -> Mono.just(s.toUpperCase())));
    }

    Flux<String> interleave(Flux<String> flux1, Flux<String> flux2){
        return flux1.mergeWith(flux2);
    }

    Flux<String> combine(Flux<String> flux1, Flux<String> flux2){
        return flux1.concatWith(flux2);
    }

    Flux<String> provideFallbackStreamForError(Flux<String> flux) {
        return flux.onErrorResume(e -> Flux.just("foo", "bar"));
    }

    public static void main(String[] args){
        TransformingStreamDemo streamDemo = new TransformingStreamDemo();
        Long beginTime, endTime;

        /*streamDemo.toUpperCase(Mono.just("sawfaefg")).subscribe(System.out::println);

        Mono<String> unitblock = Mono.just("sasd");
        String strgetfromMono = unitblock.map(e->{return e.toUpperCase();}).block();
        System.out.println("strgetfromMono: " + strgetfromMono);*/

        beginTime = System.nanoTime();
        Flux<String> flux1 = streamDemo.toUpperCaseFlux(Flux.just("alice","ben","bush","christ","ego","father","go","hello"));
        System.out.println("串行的：" + String.valueOf((System.nanoTime() - beginTime)));
        flux1.subscribe(System.out::print);

        beginTime = System.nanoTime();
        Flux<String> flux2 = streamDemo.asyncToUpperCase(Flux.just("alice","ben","bush","christ","ego","father","go","hello"));
        System.out.println("并行化：" + String.valueOf((System.nanoTime() - beginTime)));
        flux2.subscribe(System.out::print);

        /*
        beginTime = System.nanoTime();
        Iterable<String> flux2sync = flux2.toIterable();
        System.out.println("并行串行化："+String.valueOf(System.nanoTime() - beginTime));
        //flux2sync.forEach(System.out::println);

        Flux<String> flux3 = streamDemo.asyncToUpperCase(Flux.just("first", "second", "third", "forth"));
        Flux<String> flux4 = streamDemo.asyncToUpperCase(Flux.just("fifth", "sixth", "seventh", "eighth"));

        beginTime = System.nanoTime();
        streamDemo.interleave(flux3, flux4);
        System.out.println(System.nanoTime() - beginTime);

        beginTime = System.nanoTime();
        streamDemo.combine(flux3, flux4);
        System.out.println(System.nanoTime() - beginTime);

        //streamDemo.provideFallbackStreamForError(Flux.just("asd")).subscribe(System.out::println);
        */
    }
}
