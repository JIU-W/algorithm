package com.itjn.other.线上笔试.作业帮;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = sc.next();
        String key = sc.next();
        //url = url.split("com")[1];

        String[] str = url.split("&");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            String k,v;
            if(i == 0){
                String temp = str[i].split("=")[0];
                int index = -1;
                for (int j = 0; j < temp.length(); j++) {
                    if(temp.charAt(j) == '?'){
                        index = j;
                        break;
                    }
                }
                StringBuilder sb = new StringBuilder(temp);
                sb = sb.delete(0, index + 1);
                k = sb.toString();
            }else{
                k = str[i].split("=")[0];
            }
            v = str[i].split("=")[1];
            map.put(k,v);
        }
        System.out.println(map.get(key));
    }

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = sc.next();
        String key = sc.next();
        url = url.split(".com")[1];
        String[] str = url.split("&");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            String k,v;
            if(i == 0){
                String temp = str[i].split("=")[0];
                StringBuilder sb = new StringBuilder(temp);
                sb = sb.deleteCharAt(0);
                k = sb.toString();
                v = str[i].split("=")[1];
            }else{
                k = str[i].split("=")[0];
                v = str[i].split("=")[1];
            }
            map.put(k,v);
        }
        System.out.print(map.get(key));
    }*/
}
