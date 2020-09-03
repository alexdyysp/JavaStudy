package com.stackoverflow.q20200903;

import reactor.core.publisher.Flux;

/**
 * @Author daiyuanyang
 * @Date 2020/9/3 6:17 下午
 */
public class FluxOrList {
    public void process(){
        Item item = new Item();

        Flux<Integer> fI = Flux.just(1,2,3);
        item.setIdFluxList(fI);
    }
}
