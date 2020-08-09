package com.Study.Thread.BlockUntilAnother.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    class TaskA implements Runnable{
        private CountDownLatch downLatch;
        private String taskName;

        public TaskA(CountDownLatch downLatch, String taskName) {
            this.downLatch = downLatch;
            this.taskName = taskName;
        }

        @Override
        public void run() {

            System.out.println("开始TaskA执行");
            new SampleService().method1(downLatch);
        }
    }

    class TaskB implements Runnable{
        private CountDownLatch downLatch;
        private String taskName;

        public TaskB(CountDownLatch downLatch, String taskName) {
            this.downLatch = downLatch;
            this.taskName = taskName;
        }

        @Override
        public void run() {
            try {
                this.downLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i=0; i<5; i++){
                System.out.println("TaskB" + "==>" + i);
            }
        }
    }


    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(2);
        CountDownLatchTest ct = new CountDownLatchTest();
        CountDownLatch downLatch = new CountDownLatch(1);
        service.execute(ct.new TaskB(downLatch, "B"));
        service.execute(ct.new TaskA(downLatch, "A"));
        service.shutdown();
//        ct.new TaskB(downLatch, "B").run();
//        ct.new TaskA(downLatch, "A").run();
    }
}
