package com.stackoverflow.easyQuestion;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class publishOnVsSubscribeOn {

    public static Flux comSubscribeOn(){
        return Flux.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.parallel())
                .map(i -> i * 2);
    }

    public static Flux comPublishOn(){
        return Flux.just(1, 2, 3, 4)
                .map(i -> i * 2)
                .publishOn(Schedulers.elastic());
    }


    public static void main(String[] args){
        System.out.println("----- subscribeOn -----");
        comSubscribeOn().subscribe(System.out::println);
        System.out.println("---------------");

        System.out.println("----- publishOn -----");
        comPublishOn().subscribe(System.out::println);
        System.out.println("---------------");
    }

}
