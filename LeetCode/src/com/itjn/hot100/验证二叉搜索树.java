package com.itjn.hot100;

public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isBST(TreeNode node, long low, long upper) {
        if(node == null){
            return true;
        }
        if(node.val <= low || node.val >= upper){
            return false;
        }
        return isBST(node.left, low, node.val) && isBST(node.right, node.val, upper);
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
