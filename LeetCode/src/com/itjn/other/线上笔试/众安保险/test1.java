package com.itjn.other.线上笔试.众安保险;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        if(a.length == 1){
            System.out.println(1);
            return;
        }
        if(a.length == 2){
            if(a[1] - a[0] <= 20){
                System.out.println(1);
                return;
            }else {
                System.out.println(2);
                return;
            }
        }
        int i = 0, j = 2;
        int count = 0, index;
        while(true){
            if(a[j] - a[i] > 10){
                j--;
            }
            if(j == i + 1 && a[j] - a[i] > 20){
                j--;
            }
            count++;
            if(j + 1 == n || j + 2 == n || j + 3 == n){
                index = j;
                break;
            }
            i = j + 1;
            j = i + 2;
        }
        if(index + 2 == n)count++;
        if(index + 3 == n){
            if(a[index + 2] - a[index + 1] <= 20){
                count++;
            }else {
                count += 2;
            }
        }
        System.out.println(count);
    }
}
