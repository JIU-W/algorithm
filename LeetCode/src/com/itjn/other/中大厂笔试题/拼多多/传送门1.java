package com.itjn.other.中大厂笔试题.拼多多;

import java.util.Arrays;
import java.util.Scanner;

public class 传送门1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] < 0){
                a[i] = -a[i];
            }
            sum += a[i];
        }
        System.out.println(sum);

    }
}
