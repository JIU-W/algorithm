package com.itjn.hot100;

import java.util.Arrays;

public class eleven {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    //方法一：双指针
    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while(l<r){
            int area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max,area);
            if(height[l] <= height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }

    //方法二：暴力解法
    public static int maxArea2(int[] height) {
        int max = 0;
        int h = -1;
        for (int i = 0; i < height.length; i++) {
            if(height[i] > h){
                h = height[i];
            }else{
                continue;
            }
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(Math.min(height[i],height[j])*(j-i),max);
            }
        }
        return max;
    }


}
