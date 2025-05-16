package com.itjn.hot100.二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大深度 {
    public static void main(String[] args) {


    }

    //深度优先搜索(递归)
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax) + 1;
        }
    }

    //广度优先搜索
    public int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDept = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size != 0){
                TreeNode head = queue.poll();
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
                size--;
            }
            maxDept++;
        }
        return maxDept;
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
