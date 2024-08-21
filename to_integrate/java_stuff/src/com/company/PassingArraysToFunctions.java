package com.company;

public class PassingArraysToFunctions {
    public static double average(double[] a) {
        double sum=0;
        for(int i=0;i<a.length;i++) {
            sum+=a[i];
        }
        return sum/a.length;
    }
    public static void print_length_of_array(double[] a) {
        System.out.println("The length of the array is "+a.length);
    }
    public static void main(String[] args) {
        double[] a=new double[3];
        a[0]=1;
        a[1]=2;
        a[2]=3;
        System.out.println("The average is: "+average(a));
    }
}
