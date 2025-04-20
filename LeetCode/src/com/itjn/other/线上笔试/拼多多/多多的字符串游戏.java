package com.itjn.other.线上笔试.拼多多;

import java.util.Arrays;
import java.util.Scanner;

public class 多多的字符串游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        StringBuilder sb = new StringBuilder("");
        while(N-->0){
            String s = sc.next();
            int x = sc.nextInt();
            char[] cc = s.toCharArray();
            Arrays.sort(cc);
            String ss = new String(cc);
            //s = Arrays.toString(cc);
            for (int i = 0; i < x; i++) {
                char c = ss.charAt(i);
                sb.append(c);
            }
        }
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        //String T = Arrays.toString(chars);
        String T = new String(chars);
        System.out.println(T);
    }
}
