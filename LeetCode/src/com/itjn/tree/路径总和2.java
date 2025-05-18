package com.itjn.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 路径总和2 {
    public static void main(String[] args) {


    }

    List<List<Integer>> ret = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.remove(path.size() - 1);
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
