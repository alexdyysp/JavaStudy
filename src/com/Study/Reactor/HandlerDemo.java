package com.Study.Reactor;

import reactor.core.publisher.Flux;

public class HandlerDemo {

    public String alphabet(int letterNumber) {
        if (letterNumber < 1 || letterNumber > 26) {
            return null;
        }
        int letterIndexAscii = 'A' + letterNumber - 1;
        return "" + (char) letterIndexAscii;
    }

    public static void main(String[] args){
        HandlerDemo handlerDemo = new HandlerDemo();
        System.out.println(handlerDemo.alphabet(10));

        // 将 handle 用于一个 "映射 + 过滤 null" 的场景
        Flux<String> fluxalphabet = Flux.just(-10, 30, 13, 9, 20)
                .handle((i, sink) -> {
                   String letter = handlerDemo.alphabet(i);
                   if(letter != null){
                       sink.next(letter);
                   }
                });
        fluxalphabet.subscribe(System.out::println);
    }
}
