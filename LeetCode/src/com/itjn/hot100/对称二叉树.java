package com.itjn.hot100;

public class 对称二叉树 {
    public static void main(String[] args) {

    }

    //递归
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return dfs(root);
    }

    public boolean dfs(TreeNode root){
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null || root.right == null){
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left != right){
            return false;
        }

        return isSymmetric(root.left) && isSymmetric(root.right);
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
