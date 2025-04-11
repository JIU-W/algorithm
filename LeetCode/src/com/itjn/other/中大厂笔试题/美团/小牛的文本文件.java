package com.itjn.other.中大厂笔试题.美团;

import java.util.Scanner;

public class 小牛的文本文件 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while(count-->0){
            String s = sc.next();
            StringBuilder t = new StringBuilder("");
            int index = 0;
            char cc = s.charAt(0);
            if(cc != 'R' && cc != 'Z'){
                t.append(cc);
                index++;
            }
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                char c1 = s.charAt(i - 1);
                if(c == 'R'){
                    t = t.reverse();
                }else if(c == 'Z'){
                    if(c1 == 'R'){
                        t = t.reverse();
                    }else{
                        t.deleteCharAt(--index);
                    }
                }else{
                    t.append(c);
                    index++;
                }
            }
            System.out.println(t);
        }


    }

}
