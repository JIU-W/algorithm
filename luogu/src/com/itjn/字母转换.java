package com.itjn;

import java.util.Scanner;

public class 字母转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char inputChar = scanner.next().charAt(0);
        char outputChar = Character.toUpperCase(inputChar);//将小写字母转换为大写字母
        System.out.println(outputChar);

    }
}
