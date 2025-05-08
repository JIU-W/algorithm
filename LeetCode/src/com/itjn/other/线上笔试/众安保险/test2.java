package com.itjn.other.线上笔试.众安保险;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int y = sc.nextInt();int m = sc.nextInt();int d = sc.nextInt();
            int a = sc.nextInt();int b = sc.nextInt();int c = sc.nextInt();
            int aa = sc.nextInt();int bb = sc.nextInt();int cc = sc.nextInt();

            int preYear = a, endYear = aa;

            if((y > aa) || (y == aa && m > bb) || (y == aa && m == bb && d > cc)){
                System.out.println(0);
                break;
            }

            if(a < y){
                preYear = y;
            }
            if(a == y && b > m){
                preYear++;
            }
            if(a == y && b == m && c > d){
                preYear++;
            }
            System.out.println(endYear - preYear + 1);

        }


    }
}
