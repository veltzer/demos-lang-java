package com.company;

public class MaxLong {
    public static void main(String[] args) {
        long base=1;
        long jump=1;
        while(true) {
            long candidate=base+jump;
            if(candidate>base) {
                base=candidate;
                System.out.println("new base is "+base);
                jump*=2;
            } else {
                if(jump==1) {
                    System.out.println(base+" is the solution");
                    break;
                }
                jump=1;
            }
        }
    }
}
