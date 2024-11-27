package com.itjn.interview150;

import java.util.Arrays;

public class eighty {
    public static void main(String[] args) {
        int i = removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
        System.out.println(i);
    }

    //双指针
    public static int removeDuplicates(int[] nums) {
        //指针j
        int j = 1;
        int count = 1;//计数
        int temp = 0;//临时变量,控制当有重复个数在2个或者以上时，只保留一个。
        for (int i = 1; i < nums.length; i++) {
            //遇到相同的，多出来的只保存一个
            if(nums[i] == nums[i - 1]){
                if(temp == 0){
                    nums[j] = nums[i];
                    j++;
                    count++;
                }
                temp++;
            }
            //遇到不同的，指针j保存数据并右移
            if(nums[i] > nums[i - 1]){
                temp = 0;
                nums[j] = nums[i];
                j++;
                count++;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return count;
    }


    //同样是双指针（更简洁一点）
    public static int removeDuplicates1(int[] nums){
        //l指针
        int l = 2;
        for (int r = 2; r < nums.length; r++) {
            if(nums[r] != nums[l-2]){
                nums[l] = nums[r];
                l++;
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
        return l;
    }

}
