package com.itjn.other.中大厂笔试题.荣耀;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 子序列拆分 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] s = str.split(",");
        int a[] = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        //构建集合来动态添加数组
        List<List<Integer>> list = new ArrayList<>();

        //贪心的思想
        for (int i : a) {
            int min = Integer.MAX_VALUE;
            int count = -1;
            for (int j = 0; j < list.size(); j++) {
                List<Integer> temp = list.get(j);
                Integer tempMin = temp.get(temp.size() - 1);
                if(i < tempMin && tempMin < min){
                    min = tempMin;
                    count = j;
                }
            }
            if(count == -1){
                List<Integer> list1 = new ArrayList<>();
                list1.add(i);
                list.add(list1);
            }else{
                list.get(count).add(i);
            }
        }

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            List<Integer> ll = list.get(i);
            for (int j = 0; j < ll.size(); j++) {
                System.out.print(ll.get(j));
                if(j != ll.size() - 1) System.out.print(",");
            }
            System.out.println();
        }


    }
}
