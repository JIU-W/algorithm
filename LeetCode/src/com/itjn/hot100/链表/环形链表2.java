package com.itjn.hot100.链表;

import java.util.HashSet;
import java.util.Set;

public class 环形链表2 {
    public static void main(String[] args) {

    }

    //哈希表
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }

    //双指针(快慢指针法)
    public ListNode detectCycle1(ListNode head) {
        ListNode show = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            show = show.next;
            fast = fast.next.next;
            if (fast == show) {
                //通过数学计算可得：当发现 slow 与 fast 相遇时，我们再额外使用一个指针 temp，
                //起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
                ListNode temp = head;
                while(temp != show){
                    show = show.next;
                    temp = temp.next;
                }
                return temp;
            }
        }
        return null;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
