package com.itjn.hot100;

import java.util.HashMap;
import java.util.Map;
/**
 * @description 哈希表 + 双向链表
 * @author JIU-W
 * @date 2025-04-27
 * @version 1.0
 */
public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;

    //伪头部节点和伪尾部节点
    private DLinkedNode head, tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //先通过哈希表定位
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //key存在，移到头部
        moveToHead(node);
        //返回结果
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加进哈希表
            cache.put(key, newNode);
            //添加至双向链表的头部
            addToHead(newNode);
            size++;
            if (size > capacity) {
                //如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                //删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        }
        else {
            //如果key存在，先通过哈希表定位，再修改value并移到头部
            node.value = value;
            //移到头部
            moveToHead(node);
        }
    }

    //添加至双向链表的头部
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //将节点移到头部
    private void moveToHead(DLinkedNode node) {
        //1.先移除当前操作的节点
        removeNode(node);
        //2.再将当前操作的节点添加到双向链表的头部
        addToHead(node);
    }

    //删除双向链表的尾部节点
    private DLinkedNode removeTail() {
        //res是尾节点
        DLinkedNode res = tail.prev;
        //移除节点(尾节点)
        removeNode(res);
        return res;
    }

    //移除节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
