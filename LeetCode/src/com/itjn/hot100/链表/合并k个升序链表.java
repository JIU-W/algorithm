package com.itjn.hot100.链表;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并k个升序链表 {
    public static void main(String[] args) {
        new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return 0;
            }
        });

    }

    //方法一：顺序合并
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null){
            return null;
        }
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode pree = new ListNode();
        ListNode pre = pree;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return pree.next;
    }

    //方法二：分治合并


    //方法三：使用优先队列合并

    //将优先队列里存的只是各个链表的头结点，并将各个链表的头结点按"升序排序"。
    PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> {return o1.val - o2.val;}));

    public ListNode mergeKLists1(ListNode[] lists) {
        for(ListNode node : lists){
            if(node != null){
                pq.offer(node);
            }
        }

        ListNode pre = new ListNode();
        ListNode cur = pre;
        while(!pq.isEmpty()){
            ListNode poll = pq.poll();
            cur.next = poll;
            cur = cur.next;
            poll = poll.next;
            //将"弹出的头结点"的下一个结点加入到优先队列去参与排序
            if(poll != null){
                pq.offer(poll);
            }
        }
        return pre.next;
    }



    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


}
