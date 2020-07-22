package com.Study.Reactor;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class SampleSubscriber<T> extends BaseSubscriber {

    public void hookOnSubscrine(Subscription subscription){
        System.out.println("Subscribed...");
        request(1);
    }

    @Override
    protected void hookOnNext(Object value) {
            System.out.println(value);
            request(1);
        }
}
