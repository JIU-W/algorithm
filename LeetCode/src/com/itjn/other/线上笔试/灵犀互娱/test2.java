package com.itjn.other.线上笔试.灵犀互娱;

public class test2 {
    public static void main(String[] args) {


    }

    public boolean hasPathSum (TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        boolean dfs = dfs(root, sum);
        return dfs;
    }

    public boolean dfs(TreeNode root, int sum){
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return dfs(root.left,sum - root.val) || dfs(root.right,sum - root.val);
    }


    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
  }

}
