package com.itjn.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 找出两数组的不同 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {2, 4, 6};
        List<List<Integer>> difference = findDifference1(a, b);
        for (List<Integer> integers : difference) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
        }
    }

    //方法一：暴力解法
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> res1 = new HashSet<>();
        Set<Integer> res2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if(notInclude(nums1[i], nums2)) res1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(notInclude(nums2[i], nums1)) res2.add(nums2[i]);
        }
        ans.add(new ArrayList<>(res1));
        ans.add(new ArrayList<>(res2));
        return ans;
    }
    public static Boolean notInclude(int num, int[] nums2) {
        for (int i = 0; i < nums2.length; i++) {
            if (num == nums2[i]){
                return false;
            }
        }
        return true;
    }

    //方法二：哈希集合(借用set集合的contains方法)
    public static List<List<Integer>> findDifference1(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        for (int x : nums2) {
            set2.add(x);
        }
        for (int x : set1) {
            if (!set2.contains(x)) {
                res.get(0).add(x);
            }
        }
        for (int x : set2) {
            if (!set1.contains(x)) {
                res.get(1).add(x);
            }
        }
        return res;
    }


}
