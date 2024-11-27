package com.itjn.leetCode75;

public class oneThousandSevenHundredAndSixtyEight {
    public static void main(String[] args) {
        String s = mergeAlternately("abcc", "pqr");
        System.out.println(s);
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        int min = Math.min(word1.toCharArray().length, word2.toCharArray().length);
        for (int i = 0; i < min; i++) {
            sb.append(word1.toCharArray()[i]);
            sb.append(word2.toCharArray()[i]);
        }
        if(word1.length() < word2.length()){
            for (int i = word1.toCharArray().length; i < word2.toCharArray().length; i++) {
                sb.append(word2.toCharArray()[i]);
            }
        }
        if(word2.length() < word1.length()){
            for (int i = word2.toCharArray().length; i < word1.toCharArray().length; i++) {
                sb.append(word1.toCharArray()[i]);
            }
        }
        return sb.toString();
    }


}
