package com.itjn.hash;

import java.util.*;

public class 单词规律 {
    public static void main(String[] args) {
        boolean b = wordPattern("abba", "dog cat cat dog");
        System.out.println(b);
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        String[] s1 = s.split(" ");
        List<String> list = Arrays.asList(s1);

        //以下这段代码，一个split方法就搞定了！！！
        /*List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                list.add(sb.substring(0, i));
                sb.delete(0, i + 1);
                i = -1;//让i重新回到0
            }
            if (i == sb.length() - 1) {
                list.add(sb.substring(0, sb.length()));
            }
        }*/

        if(pattern.length() != list.size())return false;

        for (int i = 0; i < pattern.length(); i++) {
            char cc = pattern.charAt(i);
            String ss = list.get(i);                //用equals比较！！！
            if((map1.containsKey(cc) && !map1.get(cc).equals(ss) )||(map2.containsKey(ss) && map2.get(ss) != cc)){
                return false;
            }
            map1.put(cc, ss);
            map2.put(ss, cc);
        }
        return true;
    }

}
