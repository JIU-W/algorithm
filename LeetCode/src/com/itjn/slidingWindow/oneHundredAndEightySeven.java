package com.itjn.slidingWindow;

import java.util.*;

public class oneHundredAndEightySeven {
    public static void main(String[] args) {
        List<String> list = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String s : list) {
            System.out.println(s);
        }
    }

    //方法一：HashMap
    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int n = s.length();//不用int n = s.toCharArray().length;否则会超时
        for (int i = 0; i < n - 9; i++) {
            if (map.containsKey(s.substring(i, i + 10))){
                set.add(s.substring(i, i + 10));
            }else{
                map.put(s.substring(i, i + 10), 1);
            }
        }
        List<String> list = new ArrayList<>(set);
        return list;
    }

    //方法二：HashMap(题解的做法)
    public static List<String> findRepeatedDnaSequences1(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n - 9; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (map.get(str) == 2) {
                ans.add(str);
            }
        }
        return ans;
    }

}
