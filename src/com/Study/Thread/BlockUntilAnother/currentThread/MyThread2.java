package com.Study.Thread.BlockUntilAnother.currentThread;

public class MyThread2 implements Runnable{
    @Override
    public void run () {
        Thread currThread = Thread.currentThread ();
        System.out.println("准备执行。。。");
        synchronized (currThread)
        {
            while ("t1".equals (currThread.getName ()))
            {
                try
                {
                    currThread.wait (0);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace ();
                }
            }
            done ();
        }
    }

    public synchronized void done () {
        System.out.println ("更改完毕");
    }
}
