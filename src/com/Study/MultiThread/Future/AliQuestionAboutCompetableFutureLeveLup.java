package com.Study.MultiThread.Future;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AliQuestionAboutCompetableFutureLeveLup {

    // 任务执行后有3种状态
    static enum Result{
        SUCCESS, FAIL, CANCELLED
    }

    // 任务列表
    static List<TaskT> tasks = new ArrayList<>();

    /**
     * 任务类
     */
    public static class TaskT{
        private String name;
        private int timeInSecond;
        private Result ret;

        volatile boolean cancelling = false;
        volatile boolean cancelled = false;

        public TaskT(String name, int timeInSecond, Result ret){
            this.name = name;
            this.timeInSecond = timeInSecond * 1000;
            this.ret = ret;
        }

        /**
         * 模拟业务执行
         * 实际业务中运行时间不定，可能在处理计算，可能在请求IO
         */
        public Result runTask(){
            int interval = 100;
            int total = 0;
            try {
                for(;;){
                    Thread.sleep(interval);
                    total += interval;
                    if(total>=timeInSecond) break;
                    if(cancelled) return Result.CANCELLED;

                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name + "Task End!!!");

            return ret;
        }

        /**
         * 模拟业务取消
         * 设定了取消回滚时间
         */
        public void cancel() {
            if (!cancelled) {
                synchronized (this) {
                    if (cancelled) return;
                    cancelling = true;
                    System.out.println(name + "cancelling!!!");
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + "cancelled!!!");
                }
                cancelled = true;
            }
        }

    }

    /**
     * 通知其余线程结束（回滚）
     */
    public static void callback(Result result, TaskT task){
        if(Result.FAIL == result){
            for(TaskT _task : tasks){
                if(_task!=task){
                    _task.cancel();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TaskT subtask1 = new TaskT("task1", 3, Result.SUCCESS);
        TaskT subtask2 = new TaskT("task2", 4, Result.SUCCESS);
        TaskT subtask3 = new TaskT("task3", 1, Result.FAIL);

        tasks.add(subtask1);
        tasks.add(subtask2);
        tasks.add(subtask3);

        for(TaskT task:tasks){
            CompletableFuture f = CompletableFuture.supplyAsync(()->task.runTask())
                    .thenAccept((result -> callback(result, task)));
        }

        System.in.read();
    }
}
