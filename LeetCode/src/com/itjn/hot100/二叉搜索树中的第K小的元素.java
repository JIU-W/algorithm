package com.itjn.hot100;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉搜索树中的第K小的元素 {
    public static void main(String[] args) {


    }

    //栈模拟(中序遍历)
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        int count = 0;
        while (root != null || stack.size() != 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            count++;
            if (count == k) {
                return temp.val;
            }
            root = temp.right;
        }
        return 0;
    }

    //递归(中序遍历)
    public int kthSmallest1(TreeNode root, int k) {

        return 0;
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
