package com.itjn.stack;

import com.itjn.hot100.删除链表的倒数第N个结点;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class 最小栈 {

    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }
        public void pop() {
            stack.pop();
            minStack.pop();
        }
        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
