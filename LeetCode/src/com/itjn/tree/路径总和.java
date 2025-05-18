package com.itjn.tree;

public class 路径总和 {

    public boolean hasPathSum(TreeNode root, int sum) {
        boolean dfs = dfs(root, sum);
        return dfs;
    }

    public boolean dfs(TreeNode root, int sum) {
        //而如果真的走到了空结点，说明这个空结点的父节点的另一个子节点不为空，也就说明这个空节点不是叶子节点，所以返回false
        if (root == null) {
            return false;
        }
        //两个子节点同时为空就会校验，不会继续走下去了
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
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
