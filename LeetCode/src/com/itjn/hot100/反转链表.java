package com.itjn.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 反转链表 {
    public static void main(String[] args) {
        //测试数据输入
        /*Scanner sc = new Scanner(System.in);
        ListNode ln = new ListNode(sc.nextInt());
        ListNode head = ln;
        while (!sc.hasNextInt()){
            ListNode temp = ln;
            temp.next = new ListNode(sc.nextInt());
            ln = temp;
        }
        reverseList(head);*/
    }

    //迭代法
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //递归法
    public static ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //暴力
    public ListNode reverseList2(ListNode head) {
        ListNode ans = null;
        for (ListNode x = head; x != null; x = x.next) {
            ans = new ListNode(x.val,ans);
        }
        return ans;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

