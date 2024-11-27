package com.itjn.interview150;

import java.util.Arrays;

public class oneHundredAndSixtySeven {
    public static void main(String[] args) {
        int[] arr = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                return new int[]{i + 1,j + 1};
            }else if(numbers[i] + numbers[j] < target){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }


}
