package com.itjn.hot100.链表;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Map;

public class 随机链表的复制 {
    public static void main(String[] args) {

    }

    Map<Node, Node> map = new HashMap<>();

    //递归/回溯 + 哈希表
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(!map.containsKey(head)){
            Node newNode = new Node(head.val);
            map.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return map.get(head);
    }


    //二次遍历
    public Node copyRandomList1(Node head) {
        if (head == null)return null;
        Map<Node, Node> map = new HashMap<>(); // 原节点 -> 新节点映射
        Node curr = head;
        // 第一次遍历：创建新节点并建立映射
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        // 第二次遍历：设置next和random指针
        curr = head;
        while (curr != null) {
            Node clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
