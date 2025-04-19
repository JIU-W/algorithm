package com.itjn.other.中大厂笔试题.蚂蚁;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class 最少改变位数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        //BigInteger n = sc.nextBigInteger();
        //long n = sc.nextLong();
        String str = sc.next();
        int[] arr = new int[10001];
        int count = 0;
        int sum = 0, index = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int temp = c - '0';
            sum += temp;
            arr[index++] = temp;
        }
        if(sum >= k) {
            System.out.println(0);
            return;
        }
        Arrays.sort(arr,0 ,index);
        for (int i = 0; i < index; i++) {
            sum += (9 - arr[i]);
            count++;
            if(sum >= k) {
                System.out.println(count);
                break;
            }
        }
    }
}
