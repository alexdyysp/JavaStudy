package com.Study.MultiThread.Thread;

import java.util.stream.IntStream;

public class ThreadLocalParallel {
    public static void main(String[] args){
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("It is main Thread");

        IntStream.range(1,10).parallel().forEach(id->{
            System.out.println(String.format("%s-%s", id, local.get()));
        });

        for(int i=0; i<10; i++){
            final int id = i;
            new Thread(new Runnable(){
                @Override
                public void run() {
                    System.out.println(String.format("%s-%s", id, local.get()));
                }
            }
            ).start();
        }
    }
}
