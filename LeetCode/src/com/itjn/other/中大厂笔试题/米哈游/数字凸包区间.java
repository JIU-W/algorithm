package com.itjn.other.中大厂笔试题.米哈游;

import java.util.*;
public class 数字凸包区间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = sc.nextInt();
        }
        int min = a[1], max = a[1];
        for (int i = 1; i < n + 1; i++) {
            min = Math.min(a[i], min);
            max = Math.max(a[i], max);
            /*for(int k = 0; k < 1000000001; k++){
                if(k < min || k > max){
                    System.out.print(k + " ");
                    break;
                }
            }*/
            if(min > 0){
                System.out.print(0 + " ");
            }else if(min == 0){
                System.out.print(max + 1 + " ");
            }
        }

    }
}
