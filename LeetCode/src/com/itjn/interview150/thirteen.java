package com.itjn.interview150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class thirteen {
    public static void main(String[] args) {
        int n = romanToInt("MCMXCIV");
        System.out.println(n);
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));
            if(i < n - 1 && value < map.get(s.charAt(i + 1))){
                res -= value;
            }else{
                res += value;
            }
        }
        return res;
    }


}
