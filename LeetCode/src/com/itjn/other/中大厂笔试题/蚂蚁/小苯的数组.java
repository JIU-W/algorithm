package com.itjn.other.中大厂笔试题.蚂蚁;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 小苯的数组 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            //前缀和做预处理，用于优化查找效率
            long[] sum = new long[a.length + 1];
            for (int i = 0; i < a.length; i++) {
                sum[i + 1] = sum[i] + a[i];
            }
            long currentMin = Long.MAX_VALUE;
            while(q-- >0){
                int type = sc.nextInt();
                if(type == 1){
                    int v = sc.nextInt();
                    currentMin = Math.min(currentMin, v);
                    //不需要真的去修改值
                    /*for (int i = 0; i < a.length; i++) {
                        a[i] = Math.min(a[i], v);
                    }*/
                }else if(type == 2){
                    if(currentMin == Long.MAX_VALUE){
                        System.out.println(sum[sum.length - 1]);
                    }else{
                        long res = 0;
                        int index = a.length;
                        //通过二分查找来找到第一个大于currentMin的数的下标
                        int l = 0, r = a.length;
                        int middle;
                        while(l < r){//不能有等于号
                            middle = (l + r) / 2;
                            if(currentMin >= a[middle]){
                                l = middle + 1;
                            }else if(currentMin < a[middle]){
                                r = middle;
                            }
                        }
                        index = l;
                        //前半段的和
                        long pre = sum[index];
                        //后半段的和
                        long hou = (a.length - 1 - index + 1) * currentMin;
                        res = pre + hou;
                        System.out.println(res);
                    }
                }
            }

        }


    }

}
