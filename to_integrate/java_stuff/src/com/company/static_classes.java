package com.company;

public class static_classes {
    static class A {
    }
    public static void main(String[] args) {
        /*
        static_classes foo=new static_classes();
        A a=foo.new A();
        A another_a=foo.new A();
        */
        A a=new A();
        A b=new A();
    }
}
