package com.itjn.hot100.二叉树;

public class 二叉树的最近公共祖先 {

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs1(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return (lson || rson) || (root.val == p.val || root.val == q.val);
    }

    //二刷
    public boolean dfs1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs1(root.left, p, q);
        boolean rson = dfs1(root.right, p, q);
        if((lson && rson) || ((root.val == p.val || root.val == q.val) && ((lson || rson)))){
            ans = root;
        }
        return lson || rson || root.val == p.val || root.val == q.val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
