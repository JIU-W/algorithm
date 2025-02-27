package com.itjn.leetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class oneThousandFourHundredAndThirtyOne {

    public static void main(String[] args) {
        int[] a = new int[]{2,3,5,1,3};
        List<Boolean> res = kidsWithCandies(a, 3);
        for (Boolean b : res) {
            System.out.println(b);
        }
    }


    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = 0;
        for (int candy : candies) {
            if (candy > max){
                max = candy;
            }
        }
        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= max);
        }
        return res;
    }


}
