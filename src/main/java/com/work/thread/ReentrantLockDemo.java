package com.work.thread;



import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {


    /**重入锁 公平锁 手动加锁和释放锁 **/
    public static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        try {

            new Thread(() -> test(), "A").start();
            new Thread(() -> test(), "B").start();
            TimeUnit.SECONDS.sleep(3);
            new Thread(() -> test(), "C").start();
        }catch (Exception exception){
            exception.printStackTrace();
        }

    }

    public static void test(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get lock");
            TimeUnit.SECONDS.sleep(10);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " lost lock");
            lock.unlock();

        }
    }
}
