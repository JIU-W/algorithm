package com.itjn.hot100.二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class 验证二叉搜索树 {

    //递归
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

    //栈模拟(中序遍历)
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long temp = Long.MIN_VALUE;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if(pop.val <= temp){
                return false;
            }
            temp = pop.val;
            root = pop.right;
        }
        return true;
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
