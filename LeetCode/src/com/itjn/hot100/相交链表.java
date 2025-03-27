package com.itjn.hot100;

import javax.xml.soap.Node;
import java.util.HashSet;
import java.util.Set;

public class 相交链表 {

    public static void main(String[] args) {

    }

    //方法一：哈希表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while(temp != null){
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            if(set.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //方法二：双指针
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB){
            if(tempA == null){
                tempA = headB;
            }else{
                tempA = tempA.next;
            }
            if(tempB == null){
                tempB = headA;
            }else{
                tempB = tempB.next;
            }
        }
        return tempA;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
