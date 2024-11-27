package com.itjn.hot100;

import java.util.*;

public class fortyNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] string = {"eat","tea","tan","ate","nat", "bat"};

        /*int length = sc.nextInt();
        String[] string2 = new String[length];
        for (int i = 0; i < length; i++) {
            string2[i] = sc.next();
        }*/

        List<List<String>> lists = groupAnagrams(string);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //对字符串进行排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            //字符数组转换为字符串
            String sortStr = String.valueOf(chars);   //String sortStr = chars.toString()这个是错误写法
            //String sortStr = new String(chars);//这种方法也可以
            if(map.containsKey(sortStr)){
                map.get(sortStr).add(str);
            }else{
                List<String> strings = new ArrayList<>();
                strings.add(str);
                map.put(sortStr,strings);
            }
        }
        List<List<String>> list = new ArrayList<>(map.values());
        return list;
    }


}
