package com.itjn.hot100;

public class K个一组翻转链表 {
    public static void main(String[] args) {

    }

    //模拟
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);//引入哑结点
        hair.next = head;
        ListNode pre = hair;
        ListNode cur = head;
        while(cur != null){
            ListNode tail = pre;
            //判断剩余的结点有没有k个
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if(tail == null){
                    return hair.next;
                }
            }
            ListNode nex = tail.next;

            //进行k个结点的翻转
            ListNode[] reserve = reserve(cur, tail);
            //把子链表接回原链表中
            pre.next = reserve[0];
            reserve[1].next = nex;
            pre = reserve[1];
            cur = pre.next;
        }
        return hair.next;
    }

    public ListNode[] reserve(ListNode cur, ListNode tail) {
        ListNode head = cur;
        ListNode tempT = tail.next;//记录尾节点后一个节点，用于后续作为停止循环的条件
        ListNode pre = null;
        while(head != tempT){
            ListNode nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
        return new ListNode[]{tail, cur};
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
