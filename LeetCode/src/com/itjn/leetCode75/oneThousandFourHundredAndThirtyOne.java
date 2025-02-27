package com.itjn.leetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class oneThousandFourHundredAndThirtyOne {

    public static void main(String[] args) {
        int[] a = new int[]{2,3,5,1,3};
        List<Boolean> booleans = kidsWithCandies(a, 3);
        System.out.println(booleans);
    }


    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();

        Arrays.sort(candies);
        for (int candy : candies) {
            System.out.println(candy);
        }
        return null;
    }


}
