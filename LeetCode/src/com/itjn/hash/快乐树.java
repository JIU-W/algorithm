package com.itjn.hash;

import java.util.HashSet;
import java.util.Set;

public class 快乐树 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }


    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;// n == 1:返回true，n != 1:返回false
    }

    public static int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }

}
