package com.itjn.other.中大厂笔试题;

import java.util.Arrays;
import java.util.Scanner;

public class 数组2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int count;
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int max = 1;
            int temp = 1;
            for (int i = 1; i < n; i++) {
                if(a[i] == a[i - 1]){
                    temp++;
                }
                if(a[i] != a[i - 1]){
                    temp = 1;
                }
                max = Math.max(max, temp);
            }
            System.out.println(n - max);
        }

    }

}
