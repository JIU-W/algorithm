package com.itjn.other.线上笔试.蚂蚁;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        StringBuilder ss = new StringBuilder(s);
        int length = n;
        while(length > 1){
            StringBuilder s1 = new StringBuilder("");
            if(length % 2 == 0){
                for(int i = 0; i < length / 2; i++){
                    char c1 = ss.charAt(i);
                    char c2 = ss.charAt(ss.length() - i - 1);
                    int sum = ((c1 - '0') + (c2 - '0')) % 10;
                    s1.append(sum);
                }
            }else{
                for(int i = 0; i < length / 2 + 1; i++){
                    char c1 = ss.charAt(i);
                    char c2 = ss.charAt(ss.length() - i - 1);
                    int sum = ((c1 - '0') + (c2 - '0')) % 10;
                    s1.append(sum);
                }
            }
            //ss = new StringBuilder(s1);
            ss = s1;
            length = s1.length();
        }
        System.out.print(ss.toString());
    }
}
