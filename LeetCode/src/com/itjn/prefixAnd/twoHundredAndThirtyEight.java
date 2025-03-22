package com.itjn.prefixAnd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class twoHundredAndThirtyEight {
    public static void main(String[] args) {
        int[] ans = productExceptSelf1(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ans));
    }

    public static int[] productExceptSelf(int[] nums) {

        int ans[] = new int[nums.length];

        //前缀元素之积
        //int pre[] = new int[nums.length];
        //后缀元素之积
        int pos[] = new int[nums.length];

        //求前缀元素之积
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        //求后缀元素之积并乘起来
        pos[nums.length - 1] = 1;
        ans[nums.length - 1] = pos[nums.length - 1] * ans[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            pos[i] = pos[i + 1] * nums[i + 1];
            ans[i] = ans[i] * pos[i];
        }


        return ans;
    }

    //双指针


    //二刷
    public static int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] pos = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            pre[i] = temp;
            temp *= nums[i];
        }
        int temp2 = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            pos[i] = temp2;
            temp2 *= nums[i];
            res[i] = pre[i] * pos[i];
        }
        return res;
    }

    //二刷代码改装(把空间复杂度降下来)
    public static int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * temp;
            temp *= nums[i];
        }
        return res;
    }



}
