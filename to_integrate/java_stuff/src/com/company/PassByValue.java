package com.company;

public class PassByValue {
    public static void do_something_bad_to_x(int x) {
        x=0;
    }
    public static void main(String[] args) {
        int x=7;
        System.out.println("x is "+x);
        do_something_bad_to_x(x);
        System.out.println("x is "+x);
    }
}
