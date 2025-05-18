package com.itjn.tree;

public class 路径总和 {

    public boolean hasPathSum(TreeNode root, int sum) {
        boolean dfs = dfs(root, sum);
        return dfs;
    }

    public boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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
