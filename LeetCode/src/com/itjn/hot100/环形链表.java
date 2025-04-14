package com.itjn.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 环形链表 {
    public static void main(String[] args) {

    }

    //哈希表
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(temp != null){
            if(set.contains(temp)){
               break;
            }
            set.add(temp);
            temp = temp.next;
        }
        if(temp == null)return false;
        return true;
    }

    //快慢指针法
    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null)return false;
        ListNode show = head;
        ListNode quick = head.next;
        while(quick != null && quick.next != null){
            if(quick == show){
                return true;
            }
            quick = quick.next.next;
            show = show.next;
        }
        return false;
    }

    //这个方法和方法二思想一样，只是写法有一点点区别
    public boolean hasCycle3(ListNode head) {
        if(head == null || head.next == null)return false;
        ListNode show = head;
        ListNode quick = head;
        while(quick != null && quick.next != null){
            quick = quick.next.next;
            show = show.next;
            if(quick == show){
                return true;
            }
        }
        return false;
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
