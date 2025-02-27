package com.itjn.hash;

import java.util.*;

public class 确定两个字符串是否接近 {

    public static void main(String[] args) {
        System.out.println(closeStrings1("aacabb", "bbcbaa"));
    }


    //方法一：结合HashMap (但是代码又臭又长)
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())return false;

        Set<Character> set1 = new HashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            set1.add(c);
        }

        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            set2.add(c);
        }
        if (!set1.equals(set2)){// 判断两个字符串是否包含相同的字符 1.Set集合大小相同 2.元素相同但是顺序可以不同
            return false;
        }


        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            if (!map1.containsKey(c)) {
                map1.put(c, 1);
            } else {
                map1.put(c, map1.get(c) + 1);
            }
        }

        for (int j = 0; j < word2.length(); j++) {
            char c = word2.charAt(j);
            if (!map2.containsKey(c)) {
                map2.put(c, 1);
            } else {
                map2.put(c, map2.get(c) + 1);
            }
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        Set<Map.Entry<Character, Integer>> entries1 = map1.entrySet();
        for (Map.Entry<Character, Integer> entry : entries1) {
            list1.add(entry.getValue());
        }
        Set<Map.Entry<Character, Integer>> entries2 = map2.entrySet();
        for (Map.Entry<Character, Integer> entry : entries2) {
            list2.add(entry.getValue());
        }
        Collections.sort(list1);
        Collections.sort(list2);

        int i = 0;
        for (Integer integer : list1) {
            Integer integer1 = list2.get(i);
            if (!integer1.equals(integer)){ //和integer1  != integer不一样，一定要用equals
                return false;
            }
            i++;
        }
        return true;
    }


    //方法二：思想和方法一相同，但是代码十分简洁
    public static boolean closeStrings1(String word1, String word2) {
        int[] count1 = new int[26], count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {//检查字符集是否相同，不相同(就是一个字符串里含有另一个字符串不含有的字符)则返回false
            if ((count1[i] > 0 && count2[i] == 0 )|| (count1[i] == 0 && count2[i] > 0)) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }





}
