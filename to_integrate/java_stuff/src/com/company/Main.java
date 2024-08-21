package com.company;

public class Main {

    public static boolean is_prime(int x) {
        if(x<4) {
            return true;
        }
        int count=2;
        while(count*count<=x) {
            if(x%count==0) {
                return false;
            }
            count++;
        }
        return true;
    }

    public static void main(String[] args) {
        int count=500;
        int last_prime_found=1;
        while(true) {
            if(is_prime(count)) {
                if(last_prime_found+2==count) {
                    System.out.println("the pair is " + last_prime_found + " " + count);
                    break;
                }
                last_prime_found=count;
            }
            count++;
        }
    }
}
