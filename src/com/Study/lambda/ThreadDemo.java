package com.Study.lambda;

public class ThreadDemo {
    public static void main(String[] args){
        // traditional realize
        Runnable targett = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        new Thread(targett).start();

        // lambda realize
        Runnable target = () -> System.out.println("thread ok");
        new Thread(target).start();
    }
}
