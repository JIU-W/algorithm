package com.itjn.hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU二刷 {

    class LRULinkedNode{
        int key;
        int value;
        LRULinkedNode pre;
        LRULinkedNode next;
        public LRULinkedNode(){}
        public LRULinkedNode(int k, int v){
            this.key = k;
            this.value = v;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, LRULinkedNode> cache = new HashMap<>();

    //伪首节点、伪尾节点
    LRULinkedNode head; LRULinkedNode tail;

    public LRU二刷(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new LRULinkedNode();
        tail = new LRULinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        LRULinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        if(head.next != node){
            moveNode(node);
        }
        return node.value;
    }

    public void put(int k, int v){
        LRULinkedNode node = cache.get(k);
        if(node == null){
            LRULinkedNode newNode = new LRULinkedNode(k,v);

            //记得加缓存
            cache.put(k,newNode);

            toHead(newNode);
            size++;
            if(size > capacity){
                LRULinkedNode temp = tail.pre;
                deteleNode(temp);

                //记得减缓存
                cache.remove(temp.key);

                size--;
            }
        }else{
            node.value = v;
            moveNode(node);
        }
    }

    public void moveNode(LRULinkedNode node){
        deteleNode(node);
        toHead(node);
    }

    public void deteleNode(LRULinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void toHead(LRULinkedNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

}
