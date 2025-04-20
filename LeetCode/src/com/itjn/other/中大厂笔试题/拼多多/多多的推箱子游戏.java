package com.itjn.other.中大厂笔试题.拼多多;

import java.util.Scanner;

public class 多多的推箱子游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q-->0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == 'W'){
                    y++;
                }else if(c == 'A'){
                    x--;
                }else if(c == 'S'){
                    y--;
                }else {
                    x++;
                }
            }
            if(x == 0 && y == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}
