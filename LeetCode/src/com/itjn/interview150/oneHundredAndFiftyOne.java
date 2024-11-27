package com.itjn.interview150;

public class oneHundredAndFiftyOne {
    public static void main(String[] args) {
        String s = reverseWords("a good   example");
    }

    public static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        s = s.trim();
        String[] strs = s.split(" ");//strs:["a", "good", "", "", "example"]
        for (int i = strs.length - 1; i >= 0; i--) {
            if(!strs[i].equals("")){
                sb.append(strs[i]);
                if (i > 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }


}
