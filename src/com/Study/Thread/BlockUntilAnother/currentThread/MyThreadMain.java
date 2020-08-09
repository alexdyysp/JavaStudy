package com.Study.Thread.BlockUntilAnother.currentThread;

public class MyThreadMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        Thread t1 = new Thread(myThread1);
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(myThread2);
        t2.setName("t2");
        t2.start();
    }
}
