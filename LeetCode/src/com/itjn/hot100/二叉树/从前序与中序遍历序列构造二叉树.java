package com.itjn.hot100.二叉树;

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {

    }

    /*private Map<Integer, Integer> indexMap1;

    public TreeNode myBuildTree1(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap1.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;

        //递归地构造左子树，并连接到根节点
        //先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree1(preorder, inorder, preorder_left + 1,
                preorder_left + size_left_subtree, inorder_left, inorder_root - 1);

        //递归地构造右子树，并连接到根节点
        //先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree1(preorder, inorder, preorder_left + size_left_subtree + 1,
                preorder_right, inorder_root + 1, inorder_right);

        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap1 = new HashMap<Integer, Integer>();//构造哈希映射，帮助我们快速定位根节点
        for (int i = 0; i < n; i++) {
            indexMap1.put(inorder[i], i);
        }
        return myBuildTree1(preorder, inorder, 0, n - 1, 0, n - 1);
    }*/


    //二刷(递归 + 哈希表优化)
    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();//构造哈希映射，帮助我们快速定位根节点
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right,
                                 int inorder_left, int inorder_right) {
        if(preorder_left > preorder_right || inorder_left > inorder_right){
            return null;
        }
        //前序遍历的第一个节点就是根结点
        TreeNode root = new TreeNode(preorder[preorder_left]);
        //在中序遍历中定位根节点
        Integer index = indexMap.get(preorder[preorder_left]);

        //左子树节点数量
        int left_count = index - inorder_left;

        root.left = myBuildTree(preorder, inorder, preorder_left + 1,
                preorder_left + left_count, inorder_left, index - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + left_count + 1,
                preorder_right, index + 1, inorder_right);
        return root;
    }


    //三刷
    private Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree2(int[] preorder, int[] inorder){
        int n = inorder.length;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return bt(preorder, inorder, 0, n - 1, 0, n-1);
    }
    public TreeNode bt(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left > preorder_right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorder_left]);
        Integer inorder_root_index = map.get(preorder[preorder_left]);

        int left_count = inorder_root_index - inorder_left;

        root.left = bt(preorder, inorder, preorder_left + 1, preorder_left + left_count,
                inorder_left, inorder_root_index - 1);
        root.right = bt(preorder, inorder, preorder_left + left_count + 1, preorder_right,
                inorder_root_index + 1, inorder_right);
        return root;
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
