package com.itjn.hot100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author JIU-W
 * @version 1.0
 * @description 方法二：使用Java封装好的数据结构 LinkedHashMap
 * @date 2025-04-27
 */

public class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache2(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}
