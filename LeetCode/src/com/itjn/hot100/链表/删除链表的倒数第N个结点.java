package com.itjn.hot100.链表;

import java.util.Deque;
import java.util.LinkedList;

public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {

    }

    //方法一：计算链表长度然后找到指定位置进行删除
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        int length;
        ListNode temp = head;
        int tempL = 0;
        while(temp != null){
            tempL++;
            temp = temp.next;
        }
        length = tempL;
        int zheng = length + 1 - n;
        if(zheng == 1){
            return head.next;
        }

        int count = 0;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            count++;
            ListNode next = cur.next;
            pre = cur;
            cur = next;
            if(count == zheng - 1){
                pre.next = cur.next;
            }
        }
        return head;
    }

    //栈(通过栈来找到要删除的链表节点)
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode pre = new ListNode(-1, head);//引入哑节点：简化删除头节点时的特殊处理
        ListNode cur = pre;
        //ListNode cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode peek = stack.peek();
        /*if(peek == null){//说明是要删除头结点
            return head.next;
        }*/
        peek.next = peek.next.next;
        return pre.next;
        //return head;
    }

    //双指针(两个指针的相邻节点个数为n)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head.next == null)return null;
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        if(first == null){//说明是要删除头结点
            return head.next;
        }
        while(first.next != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return head;
    }

    //反转 -> 删除 -> 反转
    //...

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
