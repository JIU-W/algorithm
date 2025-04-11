package com.itjn.other.中大厂笔试题.阿里国际;

import java.util.Scanner;

public class 数字卡片 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int count = 0, count0 = 0,countJi = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 2 || a[i] == 4 || a[i] == 6 || a[i] == 8){
                count++;
            }else if(a[i] == 0){
                count0++;
            }else{
                countJi++;
            }
        }
        int min = Math.min(count0, countJi);
        count += min;
        System.out.print(count);
    }
}
