package com.itjn.hot100;

import java.util.*;

public class 二叉树的右视图 {
    public static void main(String[] args) {


    }

    //方法一：广度优先遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                TreeNode head = queue.poll();
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
                if(size == 0){
                    list.add(head.val);
                }
            }
        }
        return list;
    }

    //方法二：深度优先遍历
    private List<Integer> ans;
    public List<Integer> rightSideView1(TreeNode root){
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (ans.size() <= depth)
            ans.add(node.val);
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
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
