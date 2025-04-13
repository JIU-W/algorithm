package com.itjn.hot100;

public class 回文链表 {
    public static void main(String[] args) {

    }

    //对比原链表和反转后的链表
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode pre =  null;
        for(ListNode temp = head; temp != null; temp = temp.next){
            pre = new ListNode(temp.val, pre);
        }
        while(pre != null){
            if(pre.val != head.val){
                break;
            }
            pre = pre.next;
            head = head.next;
        }
        if(pre != null)return false;
        return true;
    }

    //快慢指针法(最优解法)(空间复杂度为 O(1))
    public boolean isPalindrome2(ListNode head) {

        return true;
    }

    //递归


    //栈


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
