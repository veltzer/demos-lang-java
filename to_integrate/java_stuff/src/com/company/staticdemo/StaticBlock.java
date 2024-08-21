package com.company.staticdemo;

public class StaticBlock {
    /*
    A static block is a piece of java code to be executed before any other part of the
    class.
     */
    static int x=7;

    static {
        System.out.println("This is before main");
    }

    public static void main(String[] args) {
        System.out.println("This is before hello, world!");
        System.out.println("Hello, World!");
    }
}

