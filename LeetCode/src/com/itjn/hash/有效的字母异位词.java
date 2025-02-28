package com.itjn.hash;

public class 有效的字母异位词 {
    public static void main(String[] args) {

    }


    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;

        char[] c1 = new char[26];
        char[] c2 = new char[26];
        for (int i = 0; i < s.length(); i++) {
            c1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            c2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(c1[i] != 0 && c1[i] != c2[i] || c2[i] != 0 && c2[i] != c1[i]) return false;
        }
        return true;
    }


}
