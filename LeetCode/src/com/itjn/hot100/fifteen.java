package com.itjn.hot100;

import java.util.*;

public class fifteen {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    //HashSet在添加元素时会使用元素的equals()和hashCode()方法来确定元素是否唯一。
    //对于List类型，默认的equals()和hashCode()实现是考虑元素顺序的。
    //因此，如果两个列表包含相同的元素但顺序不同，HashSet会认为它们是不同的对象，并将它们都添加到集合中。

    //排序 + 双指针
    //这道题的关键在于对结果集的“去重”
    //而去重的方式有两种：(随便使用哪一种都可以)

    // 1.使用HashSet进行去重
    //本来HashSet去重会把每个元素里面的数据顺序考虑进来，顺序不同也视为不同的元素，也会成功加入到集合中。
    //但是我们题意要求的是元素内数据顺序不同也视为相同的，所以HashSet去重就无法实现。
    //而这里仍然可以用HashSet去重的原因是“数组已经排好序了”，重复的三元组顺序必然相同。

    // 2.添加“去重”逻辑代码
    public static List<List<Integer>> threeSum111(int[] nums) {
        Set<List<Integer>> result = new HashSet<>(); //使用HashSet避免重复的三元组

        //排序：1.便于使用双指针 2.便于本题HashSet的去重
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            //一项优化
            if(nums[i] > 0)break;

            //因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
            //所以这个操作做到了对第一个指针的去重。"去重"逻辑
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1; // 第二个指针
            int k = nums.length - 1; // 第三个指针

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    //跳过所有重复的nums[j]和nums[k]，防止记录到重复组合。"去重"逻辑
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum < 0) {
                    j++;
                    //跳过所有重复的nums[j]。"去重"逻辑
                    while (j < k && nums[j] == nums[j - 1]) j++;
                } else {
                    k--;
                    //跳过所有重复的nums[k]。"去重"逻辑
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return new ArrayList<>(result); //将Set转换为List
    }

    //双重循环 + 哈希查找 + Set去重(要先对数组排好序)
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        //这里的排序一定要加上，不然HashMap的去重效果就会丢失。
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] > 0)break;
            //因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
            //所以这个操作做到了对第一个指针的去重。"去重"逻辑
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int target = 0 - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if(map.containsKey(target - nums[j])){
                    res.add(Arrays.asList(nums[i],nums[j],target - nums[j]));
                }else{
                    map.put(nums[j],j);
                }
            }
            map.clear();
        }
        return new ArrayList<>(res);
    }

}
