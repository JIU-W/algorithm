package com.itjn.hot100;

public class fortyTwo {
    public static void main(String[] args) {
        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }

    //按行求(一行一行来求)(思路不错但是超时了！！！)
    public static int trap1(int[] height) {
        int sum = 0;
        int mH = 0;//最大高度
        for (int i = 0; i < height.length; i++) {
            if (height[i] > mH) {
                mH = height[i];
            }
        }
        for (int i = 1; i <= mH; i++) {//一层一层来
            int temp = 0;//临时存储能接住的水
            boolean status = false;//标记temp是否开始更新
            for (int j = 0; j < height.length; j++) {
                //高度小于 i(当前层数),temp++  高度大于等于i,sum = sum + temp,temp = 0
                if (status && height[j] < i) {//高度小于 i(当前层数),temp++
                    temp++;
                }
                if (height[j] >= i) {
                    status = true;//第一次遇到 高度大于等于i时，就开始temp的更新
                    sum += temp;//高度大于等于i,sum = sum + temp,temp = 0
                    temp = 0;
                }
            }
        }
        return sum;
    }


    //双指针
    public static int trap(int[] height) {
        int sum = 0;
        //左右指针
        int left = 0, right = height.length - 1;
        //左指针左边的最大高度，右指针右边的最大高度
        int leftMax = height[left], rightMax = height[right];
        //最两边的列存不了水
        left++;
        right--;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                // 左指针的leftMax比右指针的rightMax矮
                // 说明：左指针的右边至少有一个板子 > 左指针左边所有板子
                // 根据水桶效应，保证了左指针当前列的水量决定权在左边
                // 那么可以计算左指针当前列的水量：左边最大高度 - 当前列高度
                sum += leftMax - height[left];
                left++;
            } else {
                //右边同理
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }

    //二刷(双指针)
    public static int trap2(int[] height){
        int sum = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        left++;
        right--;
        while(left <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax){
                sum += leftMax - height[left];
                left++;
            }else{
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }

    //动态规划

    //单调栈


}
