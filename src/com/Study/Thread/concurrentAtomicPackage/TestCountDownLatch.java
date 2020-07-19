package com.Study.Thread.concurrentAtomicPackage;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i=0; i<20; i++) {
            Thread thread = new Thread(new Work2(countDownLatch));
            thread.setName("线程-" + (i+1));
            System.out.println(Thread.currentThread().getName() + "开始时间是" + System.currentTimeMillis());
            thread.start();
            countDownLatch.countDown();
        }
    }

}

class Work2 implements Runnable {

    private final CountDownLatch countDownLatch;

    public Work2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            /**
             *
             */
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "启动时间是" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
