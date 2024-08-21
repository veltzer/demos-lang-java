package com.company;

public class PassByReference {
    public static void print_array(int[] t) {
        for(int i=0;i<t.length;i++) {
            System.out.println("element "+i+" is "+t[i]);
        }
    }
    public static void do_something_bad_to_my_array(int[] t) {
        for(int i=0;i<t.length;i++) {
            t[i]=0;
        }
    }
    public static void main(String[] args) {
        int[] a=new int[3];
        a[0]=7;
        a[1]=-12;
        a[2]=16;
        print_array(a);
        do_something_bad_to_my_array(a);
        print_array(a);
    }
}
