package com.itjn.hash;

import java.util.HashMap;
import java.util.Map;

public class 同构字符串 {

    public static void main(String[] args) {
        boolean isomorphic = isIsomorphic("egg", "add");
        System.out.println(isomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map1.containsKey(c1) && map1.get(c1) != c2){
                return false;
            }else if(!map1.containsKey(c1)){
                map1.put(c1, c2);
            }

            if(map2.containsKey(c2) && map2.get(c2) != c1){
                return false;
            }else if(!map2.containsKey(c2)){
                map2.put(c2, c1);
            }
        }

        return true;
    }

}
