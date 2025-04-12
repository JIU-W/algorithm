package com.itjn.other.线上笔试.美团;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] a = new int[length];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        int[] b = new int[sum];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j <= a[i]; j++) {
                b[index++] = j;
            }
        }
        int count = a.length;
        for (int ll = 2; ll <= b.length; ll++) {
            for (int i = 0; i < b.length - ll + 1;) {
                int j = i + ll - 1;
                int k;
                for(k = i; k <= j; k++){
                    if(b[k] > ll){
                        i = k + 1;
                        break;
                    }
                }
                if(k != j + 1)continue;

                Map<Integer, Integer> map = new HashMap<>();
                int m;
                for(m = i; m <= j; m++){
                    if(map.containsKey(b[m]))break;
                    map.put(b[m], 1);
                }
                if(m == j + 1){
                    count++;
                }
                i++;
            }
        }
        System.out.println(count);
    }
}
