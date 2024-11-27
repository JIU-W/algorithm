package com.itjn.interview150;

import java.util.HashMap;

public class twelve {
    public static void main(String[] args) {
        String s = intToRoman(3999);
        System.out.println(s);
    }

    //枚举
    public static String intToRoman1(int num) {

        //借用StringBuffer（StringBuffer是可变的,String是不可变的(很耗时间)）
        StringBuffer res = new StringBuffer();
        int qian = (num / 1000) * 1000;
        int bai = ((num % 1000) / 100) * 100;
        int shi = ((num % 100) / 10) * 10;
        int ge = num % 10;
        if(qian != 0){
            if(qian == 1000)res.append("M");
            if(qian == 2000)res.append("MM");
            if(qian == 3000)res.append("MMM");
        }
        if(bai != 0 ){
            if(bai == 900)res.append("CM");
            if(bai == 400)res.append("CD");
            if(bai == 100)res.append("C");
            if(bai == 200)res.append("CC");
            if(bai == 300)res.append("CCC");
            if(bai == 500)res.append("D");
            if(bai == 600)res.append("DC");
            if(bai == 700)res.append("DCC");
            if(bai == 800)res.append("DCCC");
        }
        if(shi != 0){
            if(shi == 90)res.append("XC");
            if(shi == 40)res.append("XL");
            if(shi == 10)res.append("X");
            if(shi == 20)res.append("XX");
            if(shi == 30)res.append("XXX");
            if(shi == 50)res.append("L");
            if(shi == 60)res.append("LX");
            if(shi == 70)res.append("LXX");
            if(shi == 80)res.append("LXXX");
        }
        if(ge != 0){
            if(ge == 9)res.append("IX");
            if(ge == 4)res.append("IV");
            if(ge == 1)res.append("I");
            if(ge == 2)res.append("II");
            if(ge == 3)res.append("III");
            if(ge == 5)res.append("V");
            if(ge == 6)res.append("VI");
            if(ge == 7)res.append("VII");
            if(ge == 8)res.append("VIII");
        }
        return res.toString();
    }

    //模拟(思路类似，但是步骤简单很多)
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

}
