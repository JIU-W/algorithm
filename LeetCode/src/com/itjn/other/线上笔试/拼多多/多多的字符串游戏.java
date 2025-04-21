package com.itjn.other.线上笔试.拼多多;

import java.util.Arrays;
import java.util.Scanner;

public class 多多的字符串游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        //统计每个字符的出现次数(比我的原始解法耗时更少，不会超时)
        int[] count = new int[26];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            int x = sc.nextInt();
            char[] chars = s.toCharArray();
            Arrays.sort(chars); // 将字符排序以选取最小的x个
            for (int j = 0; j < x && j < chars.length; j++) {
                char c = chars[j];
                count[c - 'a']++;
            }
        }

        StringBuilder result = new StringBuilder();
        int remaining = K;
        // 按字典序从a到z取字符
        for (int i = 0; i < 26 && remaining > 0; i++) {
            int take = Math.min(count[i], remaining);
            if (take > 0) {
                for (int j = 0; j < take; j++) {
                    result.append((char) ('a' + i));
                }
                remaining -= take;
            }
        }
        System.out.println(result.toString());
    }
}
