package com.work.thread;

import lombok.SneakyThrows;

public class MyDao implements Runnable{

    @Override
    @SneakyThrows
    public void run() {
        System.out.println(">>>>"  + System.currentTimeMillis());
        Thread.sleep(10000);

    }
}
