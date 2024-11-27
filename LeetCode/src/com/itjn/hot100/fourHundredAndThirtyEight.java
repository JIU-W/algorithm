package com.itjn.hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourHundredAndThirtyEight {
    public static void main(String[] args) {
        List<Integer> list = findAnagrams("cbaebabacd", "abc");
        System.out.println(list);
    }

    //定长滑动窗口，巧用数组存储字符频次，然后比较数组。
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int n = s.length(), m = p.length();
        if(n < m)return list;
        int[] int1 = new int[26];
        int[] int2 = new int[26];
        for (int i = 0; i < m; i++) {
            int1[p.charAt(i) - 'a']++;
            int2[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(int1,int2)){
            list.add(0);
        }
        int i = 0,j = m - 1;
        while(i < n - m + 1) {
            if(j == n - 1)break;
            j++;
            int2[s.charAt(j) - 'a']++;
            int2[s.charAt(i) - 'a']--;
            i++;
            if(Arrays.equals(int1,int2)){
                list.add(i);
            }
        }
        return list;
    }

    //暴力解法,比对“异位词”时需要排序，时间复杂度高。
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        p = Arrays.toString(chars);
        for (int i = 0; i < n - m + 1; i++) {
            String ss = s.substring(i, i + m);
            char[] c = ss.toCharArray();
            Arrays.sort(c);
            ss = Arrays.toString(c);
            if(ss.equals(p))list.add(i);
        }
        return list;
    }

}
