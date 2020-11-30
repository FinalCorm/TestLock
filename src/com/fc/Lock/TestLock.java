package com.fc.Lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SaleTicket1 implements Runnable {

    /**
     * 100张电影票
     */
    private static int ticket = 100;

    // 定义一个锁
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            // 加锁
            lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出了" + ticket + "张票");
                    ticket--;
                } else {
                    System.out.println(Thread.currentThread().getName() + "售罄");
                    break;
                }

                // 解除锁
            lock.unlock();
        }
    }

}

public class TestLock {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SaleTicket1(), "淘票票");
        Thread t2 = new Thread(new SaleTicket1(), "猫眼");
        Thread t3 = new Thread(new SaleTicket1(), "美团");

        t1.start();
        t2.start();
        t3.start();
    }
}
