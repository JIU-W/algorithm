package com.itjn.hash;

public class 赎金信 {

    public static void main(String[] args) {

    }

    //哈希表 + 计数 的思维
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] c1 = new char[26];
        char[] c2 = new char[26];
        for (char c : ransomNote.toCharArray()) {
            c1[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            c2[c - 'a']++;
        }
        for (int i = 0; i < c1.length; i++) {
            if(c1[i] != 0 && c2[i] < c1[i]){
                return false;
            }
        }
        return true;
    }


}
