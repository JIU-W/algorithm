package com.itjn.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class twenty {
    public static void main(String[] args) {
        boolean valid = isValid("([])");
        System.out.println(valid);
    }

    //方法一：栈 + 哈希
    public static boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1)return false;

        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(stack.empty())return false;
                if(map.get(stack.peek()) != s.charAt(i)){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    //方法二：
    public boolean isValid1(String s) {
        if(s.length() % 2 != 0) return false;
        char[] array = s.toCharArray();
        int idx = 0;
        for(char c : array){
            if(c == '('){
                array[idx ++] = ')';
            }else if(c == '['){
                array[idx ++] = ']';
            }else if(c == '{'){
                array[idx ++] = '}';
            }else if(idx == 0 || array[-- idx] != c){
                return false;
            }
        }
        return idx == 0;
    }

}

