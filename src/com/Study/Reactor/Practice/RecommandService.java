package com.Study.Reactor.Practice;

import com.google.common.util.concurrent.*;
import com.sun.istack.internal.Nullable;

import javax.security.auth.callback.Callback;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RecommandService {
    public static void main(String[] args){

        ListeningExecutorService servicePool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));

        ListenableFuture<String> future = servicePool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "s";
            }
        });

        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String integer) {
                System.out.println(integer);
            }

            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }
        }, servicePool);

        servicePool.shutdown();

    }
}
