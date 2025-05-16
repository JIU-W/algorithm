package com.itjn.interview150;

public class 买股票的最佳时机2 {
    public static void main(String[] args) {

    }

    //贪心的思想
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]){
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    //二刷
    public int maxProfit1(int[] prices){

        return 0;
    }

}
