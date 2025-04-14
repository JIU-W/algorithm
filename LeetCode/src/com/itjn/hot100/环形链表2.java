package com.itjn.hot100;

import java.util.HashSet;
import java.util.Set;

public class 环形链表2 {
    public static void main(String[] args) {

    }

    //哈希表
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(temp != null){
            if(set.contains(temp)){
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }

    //双指针




    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
