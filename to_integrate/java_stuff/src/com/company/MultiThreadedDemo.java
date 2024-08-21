package com.company;

public class MultiThreadedDemo {
    static class Thread1 extends Thread {
        @Override
        public void run() {
            int counter = 0;
            while(true) {
                System.out.println("hello from thread1 "+counter);
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter++;
            }
        }
    }
    static class Thread2 extends Thread {
        @Override
        public void run() {
            int counter = 1000;
            while(true) {
                System.out.println("hello from thread2 "+counter);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread1();
        t1.start();
        Thread t2=new Thread2();
        t2.start();
        t1.join();
        t2.join();
    }
}
