package com.itjn.hot100.链表;

public class 两数相加 {
    public static void main(String[] args) {
        ListNode node3 = new ListNode(1, null);
        ListNode node2 = new ListNode(9, node3);
        ListNode node1 = new ListNode(9, node2);

        ListNode node4 = new ListNode(1, null);
        ListNode list = addTwoNumbers(node1, node4);

        for (ListNode ll = list; ll != null; ll = ll.next) {
            System.out.println(ll.val);
        }

    }

    //模拟相加以及进位
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        int temp = 0;
        while (temp1 != null && temp2 != null) {
            int sum = temp1.val + temp2.val;
            if (temp + sum < 10) {
                res.next = new ListNode(sum + temp);
                temp = 0;
            } else {
                res.next = new ListNode((temp + sum) % 10);
                temp = (temp + sum) / 10;
            }

            res = res.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if (temp1 == null && temp2 == null) {
            if (temp != 0) {//temp为1
                res.next = new ListNode(temp);
            }
            return pre.next;
        }

        if (temp1 == null) {
            while (temp2 != null) {
                if (temp + temp2.val < 10) {
                    res.next = new ListNode(temp2.val + temp);
                    temp = 0;
                } else {
                    res.next = new ListNode((temp + temp2.val) % 10);
                    temp = (temp + temp2.val) / 10;
                }
                res = res.next;
                temp2 = temp2.next;
            }
        } else {
            while (temp1 != null) {
                if (temp + temp1.val < 10) {
                    res.next = new ListNode(temp1.val + temp);
                    temp = 0;
                } else {
                    res.next = new ListNode((temp + temp1.val) % 10);
                    temp = (temp + temp1.val) / 10;
                }
                res = res.next;
                temp1 = temp1.next;
            }
        }

        if (temp != 0) {//temp为1
            res.next = new ListNode(temp);
        }

        return pre.next;
    }

    //二刷
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode pre = new ListNode();
        ListNode res = pre;
        int temp = 0;
        while(temp1 != null && temp2 != null){
            int v = temp1.val + temp2.val;
            if(v + temp < 10){
                res.next = new ListNode(v + temp);
                temp = 0;
            }else{
                res.next = new ListNode((v + temp) % 10);
                temp = 1;
            }
            res = res.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if(temp1 == null && temp2 == null){
            if(temp != 0){
                res.next = new ListNode(temp);
            }
            return pre.next;
        }

        if(temp1 == null){
            while(temp2 != null){
                if(temp2.val + temp < 10){
                    res.next = new ListNode(temp2.val + temp);
                    temp = 0;
                }else{
                    res.next = new ListNode((temp2.val + temp) % 10);
                    temp = 1;
                }
                temp2 = temp2.next;
                res = res.next;
            }
        }else{
            while(temp1 != null){
                if(temp1.val + temp < 10){
                    res.next = new ListNode(temp1.val + temp);
                    temp = 0;
                }else{
                    res.next = new ListNode((temp1.val + temp) % 10);
                    temp = 1;
                }
                temp1 = temp1.next;
                res = res.next;
            }
        }

        if(temp != 0){
            res.next = new ListNode(temp);
        }
        return pre.next;
    }

    public static class ListNode {
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
