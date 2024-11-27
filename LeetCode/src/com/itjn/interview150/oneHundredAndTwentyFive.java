package com.itjn.interview150;

import java.util.Locale;

public class oneHundredAndTwentyFive {
    public static void main(String[] args) {
        boolean b = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(b);
    }


    //调API
    public static boolean isPalindrome(String s) {
        if(s.length() == 0)return true;
        StringBuffer sb = new StringBuffer(s.toLowerCase());
        for (int i = 0; i < sb.length(); i++) {
            if(!((sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') ||
                    (sb.charAt(i) >= '0' && sb.charAt(i) <= '9'))){
                sb.replace(i,i + 1,"");
                i--;//删除后，指针会后移，所以要减一
            }
        }
        StringBuffer sb1 = new StringBuffer(sb);
        String s1 = sb1.toString();
        sb.reverse();
        String s2 = sb.toString();
        if(s1.equals(s2))return true;
        return false;
    }

    //双指针。。。


}
