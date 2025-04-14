package com.itjn.hot100;

public class 回文链表 {
    public static void main(String[] args) {
        ListNode node6 = new ListNode(1, null);
        ListNode node5 = new ListNode(2, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(isPalindrome2(node1));
    }

    //对比原链表和反转后的链表
    public static boolean isPalindrome(ListNode head) {
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
    public static boolean isPalindrome2(ListNode head) {
        //通过快慢指针找到链表前半部分的尾节点
        ListNode i = head;
        ListNode j = head;
        while(j.next != null && j.next.next != null){
            i = i.next;
            j = j.next.next;
        }
        //反转后半部分链表
        ListNode pre = null;
        ListNode cur = i;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        /*for (ListNode x = head; x != null; x = x.next) {
            System.out.println(x.val);
        }
        for (ListNode x = pre; x != null; x = x.next) {
            System.out.println(x.val);
        }*/
        //判断是否回文
        ListNode tempH = head;
        ListNode tempP = pre;
        //System.out.println(pre.val);
        while(tempH != null){
            if(tempH.val != tempP.val){
                break;
            }
            tempH = tempH.next;
            tempP = tempP.next;
        }

        //链表复原，也就是再次反转后半部分的链表(可做可不做的操作)
        ListNode pree = null;
        ListNode curr = pre;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pree;
            pree = curr;
            curr = next;
        }

        if(tempH == null){
            return true;
        }
        return false;
    }

    //递归

    //栈


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
