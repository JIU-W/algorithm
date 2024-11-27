package com.itjn.prefixAnd;

public class oneThousandSevenHundredAndThirtyTwo {
    public static void main(String[] args) {
        int i = largestAltitude(new int[]{-5, 1, 5, 0, -7});
        System.out.println(i);
    }

    public static int largestAltitude(int[] gain) {
        int[] sum = new int[gain.length + 1];
        sum[0] = 0;
        int max = sum[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + gain[i - 1];
            if(sum[i] > max)max = sum[i];//max = Math.max(max, sum[i]);
        }
        return max;
    }

}
