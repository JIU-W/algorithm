package com.itjn.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class 下一个更大元素1 {
    public static void main(String[] args) {


    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int[] temp = new int[nums2.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                Integer pop = stack.pop();
                temp[pop] = nums2[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] == 0)temp[i] = -1;
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer index = map.get(nums1[i]);
            res[i] = temp[index];
        }
        return res;
    }

}
