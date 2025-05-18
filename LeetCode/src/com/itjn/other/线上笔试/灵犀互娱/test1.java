package com.itjn.other.线上笔试.灵犀互娱;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class test1 {
    public static void main(String[] args) {
        test1 test1 = new test1();
        boolean check = test1.check("]");
        System.out.println(check);
    }

    public boolean check (String s) {
        //Stack<Character> stack = new Stack<>();//!!!
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')'){
                if(stack.peek() == null || !stack.peek().equals('(')){
                    return false;
                }else{
                    stack.pop();
                }
            }else if(c == '}'){
                if(stack.peek() == null || !stack.peek().equals('{')){
                    return false;
                }else{
                    stack.pop();
                }
            }else if(c == ']'){
                if(stack.peek() == null || !stack.peek().equals('[')){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }


}
