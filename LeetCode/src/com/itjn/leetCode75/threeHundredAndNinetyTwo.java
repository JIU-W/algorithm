package com.itjn.leetCode75;

public class threeHundredAndNinetyTwo {
    public static void main(String[] args) {
        boolean b = isSubsequence("abc", "ahbgdc");
        System.out.println(b);
    }



    public static boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if(m == 0)return true;
        if(m > n)return false;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(j) == t.charAt(i)){
                j++;
            }
            if(j == m)return true;
        }
        return false;
    }

}
