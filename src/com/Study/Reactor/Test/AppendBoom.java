package com.Study.Reactor.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AppendBoom {

    public <T> Flux<T> appendBoomerror(Flux<T> source){
        return source.concatWith(Mono.error(new IllegalArgumentException("Boom")));
    }

}
