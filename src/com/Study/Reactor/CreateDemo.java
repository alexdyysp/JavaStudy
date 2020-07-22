package com.Study.Reactor;

import reactor.core.publisher.Flux;

import java.util.List;

public class CreateDemo {
    public static void main(String[] args) {
        Flux<String> bridge = Flux.create(sink -> {
            new MyEventListener<String>() {
                @Override
                public void onDataChunk(List<String> chunk) {
                    for(String s: chunk){
                        sink.next(s);
                    }
                }

                @Override
                public void processComplete() {
                    sink.complete();
                }
            };
        });

        bridge.subscribe();
    }
}
