package com.itjn.interview150;

public class oneHundredAndTwentyOne {
    public static void main(String[] args) {
        int i = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(i);
    }

    //暴力解法(超时)
    public static int maxProfit1(int[] prices) {
        int[] temp = new int[prices.length];
        int max, res = 0;
        for (int i = 0; i < prices.length; i++) {
            max = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i] && prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
            temp[i] = max;
        }
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] > res)res = temp[i];
        }
        return res;
    }

    //一次遍历
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, res = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            if(prices[i] - min > res)
                res = prices[i] - min;
        }
        return res;
    }

    //二刷
    public static int maxProfit2(int[] prices){
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

}
