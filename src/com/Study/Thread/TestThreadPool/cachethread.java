package com.Study.Thread.TestThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class cachethread {
    public static void method() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int index = i;
            Thread.sleep(1000);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  " + index);
                }
            });
        }
    }

    public static void main(String[] args) throws Exception {

        method();
    }

}
