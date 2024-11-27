package com.itjn.erFenChaZhao;

public class sevenHundredAndFour {
    public static void main(String[] args) {
        int search = search1(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        System.out.println(search);
    }

    //区间“左闭右闭式”写法
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle;
        while(left <= right){
            middle = (left + right) / 2;//middle = left + ((right - left) >> 1)
            if(target < nums[middle]){
               right = middle - 1;
            }else if(target > nums[middle]){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }


    //区间“左闭右开式”写法
    public static int search1(int[] nums, int target) {
        int left = 0, right = nums.length;//nums.length取不到，所以是“右开”
        int middle;
        while(left < right){//区间“左闭右闭式”写法
            middle = (left + right) / 2;
            if(target < nums[middle]){
                right = middle;//因为区间是“右开”，right不能等于middle - 1
            }else if(target > nums[middle]){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

}
