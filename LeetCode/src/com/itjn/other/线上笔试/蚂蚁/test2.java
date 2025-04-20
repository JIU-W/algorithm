package com.itjn.other.线上笔试.蚂蚁;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int max = a[n - 1];
        int min = a[0];
        int zhong;
        if(max % 2 == 0){
            zhong = max / 2;
        }else{
            zhong = max / 2 + 1;
        }
        int sum = 0;
        for(int i = 0; a[i] < zhong; i++){
            sum += zhong - a[i];
        }
        int sum1 = max - (min * 2);
        System.out.println(Math.min(sum, sum1));
    }
}
