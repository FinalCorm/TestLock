package com.fc.Lock;

class SaleTicket implements Runnable {

    /**
     * 100张电影票
     */
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (SaleTicket.class) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出了" + ticket + "张票");
                    ticket--;
                } else {
                    System.out.println(Thread.currentThread().getName() + "售罄");
                    break;
                }
            }
        }
    }

}


public class Demo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SaleTicket(), "淘票票");
        Thread t2 = new Thread(new SaleTicket(), "猫眼");
        Thread t3 = new Thread(new SaleTicket(), "美团");

        t1.start();
        t3.start();
        t2.start();
    }
}
