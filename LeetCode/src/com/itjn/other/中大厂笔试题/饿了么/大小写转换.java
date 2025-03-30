package com.itjn.other.中大厂笔试题.饿了么;

import java.util.Arrays;
import java.util.Scanner;

public class 大小写转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str = sc.next();
        int q = sc.nextInt();
        StringBuilder sb = new StringBuilder("");
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if((i + 1) % k == 0){
                if(chars[i] >= 65 && chars[i] <= 90){
                    sb.append(Character.toLowerCase(chars[i]));
                }else{
                    sb.append(Character.toUpperCase(chars[i]));
                }
            }else{
                sb.append((int)chars[i] + "");
            }
        }
        while(q-->0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(sb.substring(l - 1,r));
        }
    }
}
