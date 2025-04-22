package com.itjn.hot100;

import java.util.LinkedList;
import java.util.Queue;

public class 翻转二叉树 {
    public static void main(String[] args) {


    }

    //方法一：递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    //方法二：迭代(也就是广度优先遍历)
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            TreeNode temp = head.left;
            head.left = head.right;
            head.right = temp;
            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }



        }
        return root;
    }


    public class TreeNode {
        TreeNode left;
        int val;
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
