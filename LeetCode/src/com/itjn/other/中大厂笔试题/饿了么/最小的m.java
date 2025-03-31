package com.itjn.other.中大厂笔试题.饿了么;

import java.util.Scanner;

public class 最小的m {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            //本质上就是求n的最大质因数
            if (n == 1) {
                System.out.println(0);
                continue;
            }
            int x = n;
            int res = -1;//记录当前找到的最大质因数
            //质因数分解循环
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {//是因数
                    res = Math.max(res, i);
                    while (x % i == 0) {
                        x /= i;
                    }
                }
            }
            if (x > 1 && x > res) {
                res = x;
            }
            //res为n的最大质因数
            System.out.println(n / res);
            continue;
        }

    }
}
