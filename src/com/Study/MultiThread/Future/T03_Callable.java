package com.Study.MultiThread.Future;


import java.util.concurrent.*;

public class T03_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "com.Hello Callable";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();

        Future<String> future = service.submit(callable);  // submit()是异步的

        System.out.println(future.get());  // get()方法是同步阻塞的

        service.shutdown();

    }
}
