package com.itjn.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 独一无二的出现次数 {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(a));
    }


    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        Set<Integer> keySet = map.keySet();

        Set<Integer> set = new HashSet<>();
        for (Integer integer : keySet) {
            set.add(map.get(integer));
        }
        return keySet.size() == set.size();
    }


}
