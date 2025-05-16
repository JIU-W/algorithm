package com.itjn.hot100;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        全排列 全排列 = new 全排列();
        List<List<Integer>> list = 全排列.permute(nums);
        System.out.println(list);
    }

    //深度优先搜索、回溯、递归
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0){
            return res;
        }
        //状态数组(标记数组)
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, List<Integer> path,
                    boolean[] used, List<List<Integer>> res) {
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                //递归
                dfs(nums, len, depth + 1, path, used, res);
                //回溯
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    //二刷
    public List<List<Integer>> permute1(int[] nums){
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        boolean[] status = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(res, path, nums, len, status, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int len,
                    boolean[] status, int depth){
        if(depth == len){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if(!status[i]){
                path.add(nums[i]);
                status[i] = true;
                dfs(res, path, nums, len, status, depth + 1);
                //回溯
                status[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}
