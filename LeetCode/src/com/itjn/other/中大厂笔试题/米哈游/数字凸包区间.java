package com.itjn.other.中大厂笔试题.米哈游;

import java.util.*;
public class 数字凸包区间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            //int temp = 0;
            int res = 1000000001;
            for (int j = n - 1; j > i; j--) {
                if(a[j] < res){
                    res = a[j];
                }
            }
            System.out.print(res + " ");
        }

    }
}
