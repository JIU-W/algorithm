package com.itjn.other.线上笔试.灵犀互娱;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test3 {
    public static void main(String[] args) {


    }

    public int[][] indexPairs (String text, String[] words) {
        //List<int[]> list = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();


        int[][] arr = new int[words.length][2];
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 0; j < text.length(); j++) {
                char c = text.charAt(j);
                if(c == s.charAt(0)){
                    String sb = text.substring(j, j + s.length());
                    if(sb.equals(s)){
                        arr[i] = new int[]{j, j + s.length() - 1};
                        break;
                    }
                }
            }
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        return arr;
    }

}
