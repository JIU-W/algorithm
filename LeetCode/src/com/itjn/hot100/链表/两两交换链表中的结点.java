package com.itjn.hot100.链表;

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

    //方法二(也是迭代的方法)
    public ListNode swapPairs2(ListNode head){
        //创建一个哑结点
        ListNode pre = new ListNode(0, head);
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            ListNode next = node2.next;
            node1.next = next;
            node2.next = node1;
            temp.next = node2;
            temp = node1;
        }
        return pre.next;
    }

    //递归
    public ListNode swapPairs3(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs3(newHead.next);
        newHead.next = head;
        return newHead;
    }


    //二刷
    public ListNode swapPairs4(ListNode head){

        return null;
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
