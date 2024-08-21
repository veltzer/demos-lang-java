package com.company;

public class PrintingDemo {
    public static void main(String[] args) throws InterruptedException {
        int count = 1;
        int direction = 1;
        while(true) {
            System.out.print(" ".repeat(count)+"*".repeat(10-count)+"\r");
            count+=direction;
            if(count==10 || count==1) {
                direction *=-1;
            }
            Thread.sleep(1000);
        }
    }
}
