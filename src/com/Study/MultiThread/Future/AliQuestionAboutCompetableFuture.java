package com.Study.MultiThread.Future;

import java.util.concurrent.CompletableFuture;

public class AliQuestionAboutCompetableFuture {

    public static class TaskT{
        private String name;
        private int timeInSecond;
        private boolean ret;

        public TaskT(String name, int timeInSecond, boolean ret){
            this.name = name;
            this.timeInSecond=timeInSecond;
            this.ret=ret;
        }

        public Boolean call(){
            /**
             * 模拟业务执行时间
             * 实际业务中时间不定，可能在处理计算，可能在请求IO
             */
            try {
                Thread.sleep(timeInSecond);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name + "TaskT callback");
            return ret;
        }

    }

    public static void callback(Boolean result){
        if(false==result){
            /**
             * 处理结束流程
             * 一旦有返回false，则通知其他线程结束（回滚）
             * 超时处理
             */
            System.out.println("ready finish");
            System.exit(0);
        }
    }



    public static void main(String[] args) throws Exception{
        TaskT subtask1 = new TaskT("task1", 3, true);
        TaskT subtask2 = new TaskT("task2", 4, true);
        TaskT subtask3 = new TaskT("task3", 1, false);

        /**
         * CompletableFuture是非阻塞的异步的
         * 流式编程，函数式编程
         */
        CompletableFuture f1 = CompletableFuture.supplyAsync(()->subtask1.call())
                .thenAccept((result)->callback(result));
        CompletableFuture f2 = CompletableFuture.supplyAsync(()->subtask2.call())
                .thenAccept((result)->callback(result));
        CompletableFuture f3 = CompletableFuture.supplyAsync(()->subtask3.call())
                .thenAccept((result)->callback(result));

        System.in.read();
    }

}
