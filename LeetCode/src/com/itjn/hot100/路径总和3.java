package com.itjn.hot100;

public class 路径总和3 {
    public static void main(String[] args) {


    }

    //方法一：深度优先搜索(递归)
    public int pathSum(TreeNode root, long targetSum) {
        if(root == null){
            return 0;
        }
        int sum = rootSum(root, targetSum);
        sum += pathSum(root.left, targetSum);
        sum += pathSum(root.right, targetSum);
        return sum;
    }

    private int rootSum(TreeNode root, long targetSum) {
        if(root == null){
            return 0;
        }
        int ret = 0;
        if(root.val == targetSum){
            ret++;
        }
        ret += rootSum(root.left, targetSum - root.val);
        ret += rootSum(root.right, targetSum - root.val);
        return ret;
    }

    //方法二：前缀和 + 递归
    public int pathSum2(TreeNode root, long targetSum) {

        return 0;
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
