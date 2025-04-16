package com.itjn.hot100;

public class 两两交换链表中的结点 {
    public static void main(String[] args) {

    }

    //迭代
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode res = head.next;
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null && cur.next != null){
            ListNode next = cur.next;
            if(pre != null){
                pre.next = next;
            }
            cur.next = next.next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return res;
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
