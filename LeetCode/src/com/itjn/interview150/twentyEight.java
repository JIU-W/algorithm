package com.itjn.interview150;

public class twentyEight {
    public static void main(String[] args) {
        int i = strStr("hello", "ll");
        System.out.println(i);
    }

    //方法一：substring
    public static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len1 < len2)return -1;
        int index = -1;
        for (int i = 0; i < len1 - len2 + 1; i++) {
            if(haystack.substring(i, i + len2).equals(needle)){
                index = i;
                break;
            }
        }
        return index;
    }


    //方法二：indexOf
    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}
