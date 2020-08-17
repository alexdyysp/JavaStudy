package com.stackoverflow.easyQuestion;

public class ThreadX extends Thread {
    static int total = 0;

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 200; i++) {
                total = total + i;
            }
            System.out.println("c");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadX t = new ThreadX();

        t.start();
        synchronized (t) {
            t.wait();
            System.out.println("l");
        }

        System.out.println("total: " + total);
    }
}