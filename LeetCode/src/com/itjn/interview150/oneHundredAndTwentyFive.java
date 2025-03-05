package com.itjn.interview150;

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
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }

    //双指针
    public static boolean isPalindrome1(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }


}
