package com.itjn.other.线上笔试.拼多多;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 多多的电影拍摄 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 100;
            }

            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            //用于判断是否满足的了所有成员的意见
            Map<Integer, ArrayList<Integer>> map2 = new HashMap<>();
            while(m-->0){
                int a = sc.nextInt();
                int b = sc.nextInt();

                if(map2.containsKey(b)){
                    ArrayList<Integer> temp = map2.get(b);
                    for (int i = 0; i < temp.size(); i++) {
                        if(temp.get(i).equals(a)){
                            System.out.println(-1);
                            return;
                        }
                    }
                }
                if(map2.containsKey(a)){
                    ArrayList<Integer> temp = map2.get(a);
                    temp.add(b);
                    map2.put(a, temp);
                }else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(b);
                    map2.put(a, temp);
                }


                if(arr[a - 1] > arr[b - 1]){
                    continue;
                }
                while(arr[a - 1] <= arr[b - 1]){
                    arr[a - 1] += 10;
                }
                if(map.containsKey(a - 1)){
                    ArrayList<Integer> temp = map.get(a - 1);
                    for (int i = 0; i < temp.size(); i++) {
                        Integer index = temp.get(i);
                        while(arr[index] <= arr[a - 1]){
                            arr[index] += 10;
                        }
                    }
                }
                if(map.containsKey(b - 1)){
                    ArrayList<Integer> temp = map.get(b - 1);
                    temp.add(a - 1);
                    map.put(b - 1, temp);
                }else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(a - 1);
                    map.put(b - 1, temp);
                }
            }

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
        }
    }
}
