package com.itjn.other.中大厂笔试题.米哈游;

import java.util.Scanner;

public class 最大面积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] s = new int[input.length()];
        int n = s.length;
        for (int i = 0; i < input.length(); i++) {
            s[i] = input.charAt(i) - '0';
        }
        if (!containsOne(s)) {
            System.out.println(n * n);
            return;
        }

        //循环移位逻辑(把末尾的0移到数组前面来)
        int ed = n - 1;
        while (s[ed] == 0) {
            ed--;
        }
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            int index = (ed + 1 + i) % n;
            rotated[i] = s[index];
        }

        //统计最大连续0长度
        int max = 0;
        int temp = 0;
        for (int num : rotated) {
            if (num == 0) {
                temp++;
            } else {
                temp = 0;
            }
            if (temp > max)max = temp;
        }

        //计算两种形状的最大值
        //三角形的情况
        int res = max * (1 + max) / 2;
        //矩形的情况
        for (int k = 1; k <= max; k++) {
            int m = max - (k - 1);
            res = Math.max(res, k * m);
        }
        System.out.println(res);
    }

    private static boolean containsOne(int[] arr) {
        for (int num : arr) {
            if (num == 1) return true;
        }
        return false;
    }
}
