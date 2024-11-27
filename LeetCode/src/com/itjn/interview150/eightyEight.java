package com.itjn.interview150;

import java.util.Arrays;

public class eightyEight {
    public static void main(String[] args) {

        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }

    //方法二：双指针（时间复杂度：O(m+n)）
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int j = 0,k = 0;
        for (int i = 0; i < temp.length; i++) {
            if(k == n ||(j < m && nums1[j] < nums2[k])){
                temp[i] = nums1[j];
                j++;
            }else if((k < n && nums1[j] >= nums2[k]) || j == m){
                temp[i] = nums2[k];
                k++;
            }
        }
        for (int i = 0; i < m + n; i++) {
           nums1[i] = temp[i];
        }
        //为什么直接nums1 = temp不行？

        //System.out.println(Arrays.toString(nums1));

        //方法一（时间复杂度 = 快速排序时间复杂度 = O((m+n)log(m+n))）
        /*int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);*/

    }

}
