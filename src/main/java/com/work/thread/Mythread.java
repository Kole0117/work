package com.work.thread;


import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class Mythread {

    @SneakyThrows
    public static void main(String[] args) {

        // 单线程的线程池(多个任务时 进入阻塞)
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        // 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        // 定长的线程
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        // 定时执行的线程
        ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(10);

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
        ScheduledFuture<String> scheduledFuture = scheduledThreadPool.schedule(new Callable<String>() {
            public String call() throws Exception {
                return "call";
            }
        }, 10, TimeUnit.SECONDS);
        System.out.println(scheduledFuture.get());
        scheduledThreadPool.shutdown();

    }
}
