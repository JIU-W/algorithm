package com.itjn.hot100;

import java.util.Arrays;

public class 排序链表 {
    public static void main(String[] args) {


    }


    public ListNode sortList(ListNode head) {
        int[] arr = new int[50001];
        ListNode temp = head;
        int index = 0;
        while(temp != null){
            arr[index] = temp.val;
            index++;
            temp = temp.next;
        }

        Arrays.sort(arr, 0, index);

        index = 0;
        ListNode temp1 = head;
        while(temp1 != null){
            temp1.val = arr[index];
            index++;
            temp1 = temp1.next;
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
