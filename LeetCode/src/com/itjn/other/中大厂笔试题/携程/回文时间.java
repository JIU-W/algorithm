package com.itjn.other.中大厂笔试题.携程;

import java.util.Scanner;

public class 回文时间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String s1 = new StringBuilder(s).reverse().toString();
        if(s.equals(s1)){
            System.out.println(0);
            return;
        }
        int count = 0;
        String shi = s.substring(0, 2);
        int shi_Int = Integer.parseInt(shi);
        String fen = s.substring(3, 5);
        int fen_Int = Integer.parseInt(fen);
        while(true){
            fen_Int++;
            count++;
            if(fen_Int == 60){//分钟进位
                fen_Int = 0;
                shi_Int++;
            }
            if(shi_Int == 24){//时钟进位
                shi_Int = 0;
            }
            shi_Int = shi_Int % 24;
            String s2;
            if(fen_Int < 10){
                String temp = Integer.toString(fen_Int);
                s2 = "0" + temp;
            }else{
                s2 = Integer.toString(fen_Int);
            }
            //String s2 = String.format("%02d", fen_Int);  //简便处理
            String s3;
            if(shi_Int < 10){
                String temp = Integer.toString(shi_Int);
                s3 = "0" + temp;
            }else{
                s3 = Integer.toString(shi_Int);
            }
            //String s3 = String.format("%02d", shi_Int);  //简便处理
            String s4 = s3 + s2;
            if(new StringBuilder(s4).reverse().toString().equals(s4)){
                System.out.println(count);
                return;
            }
        }

    }


}
