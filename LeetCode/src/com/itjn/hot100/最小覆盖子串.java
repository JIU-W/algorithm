package com.itjn.hot100;

import java.util.*;

public class 最小覆盖子串 {
    public static void main(String[] args) {
        String s = minWindow("ADOBECODEBANC", "ABC");
        Set<Object> objects = new TreeSet<>();
        Set<Object> objects1 = new HashSet<Object>();
        System.out.println(s);
    }

    public static String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(n < m)return "";


        return "";
    }

}
