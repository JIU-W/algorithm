package com.itjn.other.中大厂笔试题.拼多多;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 多多的排队 {

    //方法一：单调栈
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            while(!stack.isEmpty() && a[i] >= a[stack.peek()]){
                Integer pop = stack.pop();
                arr[pop] = i - pop;
            }
            stack.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                arr[i] = arr.length - i - 1;
            }
            sum += arr[i];
        }
        System.out.println(sum);
    }

    //方法二：暴力
    /*public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int count = 0;
            for (int j = i + 1; j < a.length; j++) {
                count++;
                if(a[j] >= a[i]){
                    break;
                }
            }
            sum += count;
        }
        System.out.println(sum);
    }*/

}
