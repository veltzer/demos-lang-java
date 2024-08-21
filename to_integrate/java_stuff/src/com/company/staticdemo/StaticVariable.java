package com.company.staticdemo;

public class StaticVariable {
    /*
    This "static" means that there is ONLY ONE x
    and not one for each instance.
    AND it can be accessed without an instance.
    StaticVariable.x

    Rules about calling methods:
    Static methods can call:
           static methods
    Regular methods can call:
            static methods
            other regular methods
     Variable access:
     static method can access:
           static variables
     regular methods can access:
            static variables
            regular variables
     */
    static int x=7;
    int y=17;
    public static void main(String[] args) {
        StaticVariable my_object=new StaticVariable();
        // my_object.y
        System.out.println("Hello, World!" +x);
    }
    public void do_something(){
        System.out.println("Hello, World!" +x+y);
    }
}

