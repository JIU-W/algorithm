package com.itjn.other.中大厂笔试题.蚂蚁;

import java.util.Scanner;

public class 圈圈字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'b' || c == 'd' || c == 'e' || c == 'g' || c == 'o' || c == 'p' || c == 'q') {
                count++;
            }
        }
        System.out.println(count);
    }

}
