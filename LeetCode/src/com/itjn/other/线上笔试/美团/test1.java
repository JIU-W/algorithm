package com.itjn.other.线上笔试.美团;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])){
                map.put(a[i], map.get(a[i]) + 1);
            }else{
                map.put(a[i], 1);
            }
        }
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            Integer temp = map.get(a[i]);
            if(temp > max)max = temp;
        }
        System.out.println(length - max);

    }
}
