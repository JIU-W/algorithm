package com.itjn.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 反转链表 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode ln = new ListNode(sc.nextInt());
        ListNode head = ln;
        while (!sc.hasNextInt()){
            ListNode temp = ln;
            temp.next = new ListNode(sc.nextInt());
            ln = temp;
        }
        reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {

        return null;
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

