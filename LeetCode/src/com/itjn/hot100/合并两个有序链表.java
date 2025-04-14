package com.itjn.hot100;

public class 合并两个有序链表 {
    public static void main(String[] args) {

    }

    //迭代
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode preHead = new ListNode();
        ListNode temp3 = preHead;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp3.next = temp1;
                temp1 = temp1.next;
            }else{
                temp3.next = temp2;
                temp2 = temp2.next;
            }
            temp3 = temp3.next;
        }
        temp3.next = temp2 == null ? temp1 : temp2;
        return preHead.next;
    }

    //递归


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
