package com.itjn.hot100.链表;

import java.util.Arrays;

public class 排序链表 {
    public static void main(String[] args) {


    }

    //方法一：调api
    public ListNode sortList(ListNode head) {
        int[] arr = new int[50001];
        ListNode temp = head;
        int index = 0;
        while(temp != null){
            arr[index] = temp.val;
            index++;
            temp = temp.next;
        }

        Arrays.sort(arr, 0, index);

        index = 0;
        ListNode temp1 = head;
        while(temp1 != null){
            temp1.val = arr[index];
            index++;
            temp1 = temp1.next;
        }
        return head;
    }

    //方法二：手写归并排序(自顶向下的归并排序)
    public ListNode sortList1(ListNode head){
        return sortList(head, null);//说明区间是左闭右开的
    }

    public ListNode sortList(ListNode head, ListNode tail){
        if(head == null){
            return null;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        //通过"快慢指针法"找到链表的mid
        // 这个mid点并不是绝对的中点，(奇数个点的情况下：mid点是中点的后一个点)(偶数个点的情况下：mid点是中间靠右边的点)
        // 因为区间是左闭右开的，所以这么取mid点(取偏右的点)
        ListNode slow = head, fast = head;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);

        return sorted;
    }

    //相当于是"合并两个有序链表"
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode pre = new ListNode();
        ListNode temp = pre;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
               temp.next = list1;
               list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return pre.next;
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
