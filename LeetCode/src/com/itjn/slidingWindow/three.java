package com.itjn.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class three {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring1("bbbbb");
        System.out.println(i);
    }

    //暴力 + HashSet优化
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] cc = s.toCharArray();
        int count = 0, max = 0;
        for (int i = 0; i < cc.length; i++) {
            count = 0;
            for (int j = i; j < cc.length; j++) {
                if (!set.contains(cc[j])) {
                    count++;
                    set.add(cc[j]);
                } else {
                    break;
                }
            }
            max = Math.max(max, count);
            set.clear();
        }
        return max;
    }

    //滑动窗口 + HashSet
    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        char[] cc = s.toCharArray();
        int max = 0;
        int l = 0;
        for (int r = 0; r < cc.length; ) {
            if (l <= r && set.contains(cc[r])) {
                set.remove(cc[l]);
                l++;
            } else {
                set.add(cc[r]);
                r++;
            }
            max = Math.max(max, (r - 1) - l + 1);
        }
        return max;
    }

    //二刷
    public static int lengthOfLongestSubstring2(String s){
        int n = s.length();


        return 0;
    }

}
