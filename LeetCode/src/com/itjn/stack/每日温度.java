package com.itjn.stack;

public class 每日温度 {
    public static void main(String[] args) {

    }

    //方法一：暴力
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

    //单调栈
    public int[] dailyTemperatures1(int[] temperatures) {

        return null;
    }

}
