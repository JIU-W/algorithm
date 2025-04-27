package com.itjn.stack;

import java.util.Deque;
import java.util.LinkedList;

public class 每日温度 {
    public static void main(String[] args) {

    }

    //方法一：暴力(超时了)
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            int count = 0;
            int j;
            for (j = i + 1; j < temperatures.length; j++) {
                count++;
                if(temperatures[j] > temperatures[i]){
                    res[i] = count;
                    break;
                }
            }
            if(j == temperatures.length)res[i] = 0;
        }
        return res;
    }


    //方法二：暴力(不超时)
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] res = new int[temperatures.length];


        return res;
    }


    //方法三：单调栈
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > temperatures[stack.peek()]){
                Integer index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

}
