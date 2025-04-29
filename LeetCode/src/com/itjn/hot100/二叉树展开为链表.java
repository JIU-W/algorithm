package com.itjn.hot100;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉树展开为链表 {

    //方法一：前序遍历(递归)
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root,list);
        int size = list.size();
        //将二叉树展开为单链表
        for (int i = 0; i < size - 1; i++) {
            TreeNode cur = list.get(i);
            TreeNode nex = list.get(i + 1);
            cur.left = null;
            cur.right = nex;
        }
    }

    public void preorder(TreeNode root, List<TreeNode> list) {
        if(root == null){
            return;
        }
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    //方法二：寻找前驱节点(空间复杂度为O(1))
    public void flatten1(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            while(cur.left != null){
                TreeNode predecessor = cur.left;
                while(predecessor.right != null){
                    predecessor = predecessor.right;
                }
                predecessor.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
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
