package com.itjn.hot100;

public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {

    }


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
                //ListNode nextt = cur.next;
                pre.next = cur.next;
            }
        }
        return head;
    }

    //反转 -> 删除 -> 反转


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
