package com.stackoverflow.q20200903;

import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @Author daiyuanyang
 * @Date 2020/9/3 6:14 下午
 */

public class Item {

    int id;

    Flux<Integer> idFluxList;

    List<Integer> idList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flux<Integer> getIdFluxList() {
        return idFluxList;
    }

    public void setIdFluxList(Flux<Integer> idFluxList) {
        this.idFluxList = idFluxList;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}
