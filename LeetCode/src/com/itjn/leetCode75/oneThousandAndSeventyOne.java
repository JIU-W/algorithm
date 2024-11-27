package com.itjn.leetCode75;

import java.util.*;

public class oneThousandAndSeventyOne {
    public static void main(String[] args) {
        String s = gcdOfStrings1("ABABAB", "ABAB");
        System.out.println(s);
    }

    //方法一：枚举
    public static String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int min = Math.min(len1,len2);
        for (int len = min; len >= 1; len--) {//从最长的长度开始枚举
            if(len1 % len == 0 && len2 % len == 0){
                String ss1 = str1.substring(0, len);
                String ss2 = str2.substring(0, len);
                if(!ss1.equals(ss2))continue;
                if(check(str1,ss1) && check(str2,ss2)){
                    return ss1;
                }
            }
        }
        return "";
    }

    public static boolean check(String str, String s){
        StringBuffer sb = new StringBuffer();
        while(sb.length() < str.length()){
            sb.append(s);
        }
        if(sb.toString().equals(str))
            return true;
        return false;
    }

    //方法二：枚举优化(最大公约数优化)
    public static String gcdOfStrings1(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int gcd = gcd(len1, len2);
        String ss1 = str1.substring(0, gcd);
        String ss2 = str2.substring(0, gcd);
        if(!ss1.equals(ss2))
            return "";
        if(check(str1,ss1) && check(str2,ss2)){
            return ss1;
        }
        return "";
    }

    public static int gcd(int a,int b){
        int yu = a % b;
        while(yu != 0){
            a = b;
            b = yu;
            yu = a % b;
        }
        return b;
    }


    //方法三：数学 + 最大公约数
    public static String gcdOfStrings2(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if(!str1.concat(str2).equals(str2.concat(str1)))return "";
        int gcd = gcd(len1, len2);
        String s = str1.substring(0, gcd);
        return s;
    }

}
