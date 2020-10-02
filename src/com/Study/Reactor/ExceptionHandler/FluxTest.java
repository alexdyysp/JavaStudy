package com.Study.Reactor.ExceptionHandler;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author daiyuanyang
 * @Date 2020/10/2 11:54 下午
 */
public class FluxTest {

    private static ArrayList<Integer> userIdList;
    private static Repo repo;

    @Before
    public void init(){
        repo = new Repo();
        userIdList = Lists.newArrayList(1,2,30,5,3);
    }

    @Test
    public void testNoHandler(){

        Flux.fromIterable(userIdList)
                .map(repo::getById)
                .subscribe(System.out::println);
    }

    @Test
    public void testHandler(){

        Repo repo = new Repo();

        List<Integer> userIdList = Lists.newArrayList(1,2,30,5,3);

        Flux.fromIterable(userIdList)
                .handle((id, sink) -> {
                    if(!repo.isValid(id)){
                        sink.error(new IllegalArgumentException(id.toString()));
                    } else {
                        sink.next(repo.getById(id));
                    }})
                .onErrorReturn("Uh oh")
                .subscribe(System.out::println);
    }

    @Test
    public void testSwitchIfEmpty(){

        Flux.fromIterable(userIdList)
                .concatMap(repo::getById)
                .switchIfEmpty(Flux.error(new IllegalArgumentException()))
                .subscribe(System.out::println);
    }
}
