package com.itjn.stack;

import javax.xml.stream.events.Characters;
import java.util.*;


public class 字符串解码 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }


    //方法一：栈操作(这里要用LinkedList链表模拟栈，更为方便)
    static int ptr;
    public static String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>();
        ptr = 0;
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                char c = s.charAt(ptr);
                stk.addLast(c + "");
                ptr++;
            } else {
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())) {
                    String temp = stk.removeLast();
                    sub.addLast(temp);//注：只有LinkedList有addLast()方法，ArrayList和List都没有
                }
                Collections.reverse(sub);
                stk.removeLast();//左括号出栈
                int count = Integer.parseInt(stk.removeLast());//此时栈顶为当前sub对应的字符串应该出现的次数
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (count-->0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }
        //将栈里的元素进行拼接，并且是从"栈底"开始拼接，拼接到"栈顶"，
        //正是因为真正的栈Deque并不能从"栈底"开始遍历，所以为了方便，便采用LinkedList链表模拟栈。
        return getString(stk);
    }

    public static String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    //链表集合转成字符串
    public static String getString(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }



    //方法二：递归(不需要会这种方法，会一种方法(栈模拟)就行)
    public static String decodeString1(String s) {

        return null;
    }


}
