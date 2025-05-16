package com.itjn.hot100.二叉树;

public class 将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {

    }

    //二叉树的中序遍历
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums,0 , nums.length - 1);
    }

    public TreeNode convert(int[] nums, int l, int r) {
        if(l > r){
          return null;
        }
        int mid = (l + r) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = convert(nums, l, mid - 1);
        treeNode.right = convert(nums, mid + 1, r);
        return treeNode;
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
