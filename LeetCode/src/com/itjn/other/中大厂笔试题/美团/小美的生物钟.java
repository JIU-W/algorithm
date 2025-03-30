package com.itjn.other.中大厂笔试题.美团;

import java.util.Scanner;

public class 小美的生物钟 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt(), k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            if(sum <= n * k){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

            t--;
        }

    }

}
