package com.itjn.interview150;

import java.awt.font.NumericShaper;
import java.util.Arrays;

public class twentySix {
    public static void main(String[] args) {
        removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

    //双指针，思路：用指针i依次去找到所有的“相邻且不一样”一组数(两个数)，将这组数的前者利用j指针从数组头部存起。
    //这样就做到了不重复的存下数组的数据，但是“最后一组数”的“后者”计算不到，所以这种情况单独处理。
    public static int removeDuplicates1(int[] nums) {
        int j = 0;//准备好j指针
        int count = 0;//计数
        for (int i = 0; i < nums.length; i++) {
            //单独处理“最后一组数”的“后者”
            if (i == nums.length - 1) {
                count++;
                nums[j] = nums[i];
                break;
            }
            if (nums[i] != nums[i + 1]) {
                count++;
                nums[j] = nums[i];
                j++;
            }
        }
        /*for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }*/
        return count;
    }


    //方法同样是双指针，写法更简洁
    public static int removeDuplicates(int[] nums) {
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }

}

