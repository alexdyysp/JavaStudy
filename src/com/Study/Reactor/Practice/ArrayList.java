package com.Study.Reactor.Practice;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayList {

    static class Par implements Runnable{

        List<Integer> L;

        public Par(List<Integer> l) {
            L = l;
        }

        @Override
        public void run() {
            L.forEach(System.out::print);
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<List<Integer>> LL = new java.util.ArrayList<>();
        List<Integer> L = new java.util.ArrayList<>();
        L.add(1); L.add(2); L.add(3); L.add(4); L.add(5);
        LL.add(L);
        List<Integer> L1 = new java.util.ArrayList<>();
        L1.add(11); L1.add(12); L1.add(13); L1.add(14); L1.add(15);
        LL.add(L1);
        List<Integer> L2 = new java.util.ArrayList<>();
        L2.add(21); L2.add(22); L2.add(23); L2.add(24); L2.add(25);
        LL.add(L2);

        ThreadPoolExecutor executor =  new ThreadPoolExecutor(20, 20, 0L, TimeUnit.MILLISECONDS,
                //基于阻塞队列，大小设置为100
                new LinkedBlockingQueue(100),
                //拒绝策略，当队列满了之后，又达到了max size，将会将任务提交到主线程中进行处理
                new ThreadPoolExecutor.CallerRunsPolicy());

        for(int i=0; i<30; i++){
            Par p = new Par(LL.get(i%3));
            executor.execute(p);
        }



        Thread.sleep(5000);
    }
}
