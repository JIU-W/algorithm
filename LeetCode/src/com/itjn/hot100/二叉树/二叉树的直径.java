package com.itjn.hot100.二叉树;

public class 二叉树的直径 {
    public static void main(String[] args) {

    }

    //深度优先搜索
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        depth(root);
        return max - 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = depth(root.left);
        int R = depth(root.right);
        max = Math.max(max, L + R + 1);
        return Math.max(L, R) + 1;
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
