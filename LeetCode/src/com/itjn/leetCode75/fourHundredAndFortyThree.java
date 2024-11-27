package com.itjn.leetCode75;

public class fourHundredAndFortyThree {
    public static void main(String[] args) {
        int compress = compress(new char[]{'a','a','b','b','c','c','c'});
        System.out.println(compress);
        /*StringBuffer sb1 = new StringBuffer();
        sb1.append('c');
        sb1.append(12);
        System.out.println(sb1);
        int length = sb1.toString().toCharArray().length;
        System.out.println(length);*/
    }

    //双指针
    public static int compress(char[] chars) {
        StringBuffer sb = new StringBuffer();
        int j = 0,z = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if(chars[j] == chars[i]){
                count++;
            }
            if(chars[j] != chars[i]){
                sb.append(chars[j]);
                if(count > 1){
                    sb.append(count);
                }
                count = 1;
                j = i;
            }
        }
        sb.append(chars[j]);
        if(count > 1){
            sb.append(count);
        }
        chars = sb.toString().toCharArray();
        /*for (char c : chars) {
            System.out.println(c);
        }*/
        return chars.length;
    }



}
