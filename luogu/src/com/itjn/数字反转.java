package com.itjn;

import java.util.Scanner;

public class 数字反转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println(reversed);
        sc.close();
    }
}