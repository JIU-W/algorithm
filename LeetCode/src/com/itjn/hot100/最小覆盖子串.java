package com.itjn.hot100;

import java.util.Arrays;

public class 最小覆盖子串 {
    public static void main(String[] args) {
        String s = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    public static String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(n < m)return "";
        StringBuilder res = new StringBuilder("");
        int minL = 0;
        int[] temp = new int[m];
        //int max = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            temp[i] = s.indexOf(t.charAt(i));
            if(temp[i] == -1)return "";
            //if(temp[i] > max)max = temp[i];
            //if(temp[i] < min)min = temp[i];
        }
        //minL = max - min + 1;
        //int i = min, j = max;
        Arrays.sort(temp);
        minL = temp[m - 1] - temp[0] + 1;
        String minString = s.substring(temp[0], temp[m - 1] + 1);

        /*int i = temp[1], j = temp[m - 1];
        int count = j - i + 1;
        char tempC = s.charAt(temp[0]);  //'A'
        j++;
        count++;
        while(i <= j && j < n){
            if(s.charAt(j) == tempC){
                if(count < minL){
                    minL = count;
                    minString = s.substring(i, j + 1);
                }
                tempC = s.charAt(i);
                i++;
                while(true){   //s.charAt(i)
                    i++;
                }
                //i = temp[m - 1] + 1;
            }
            j++;
            count++;
        }
*/

        return res.toString();
    }

}
