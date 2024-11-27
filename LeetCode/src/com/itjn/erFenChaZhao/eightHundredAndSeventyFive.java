package com.itjn.erFenChaZhao;

public class eightHundredAndSeventyFive {
    public static void main(String[] args) {

    }

    //由于 吃香蕉的速度 和 是否可以在规定时间内吃掉所有香蕉 之间存在单调性，
    //因此可以使用二分查找的方法得到最小速度 k。
    public static int minEatingSpeed(int[] piles, int h) {
        int maxPlie = 0;
        for (int pile : piles) {
            maxPlie = Math.max(maxPlie, pile);
        }
        int left = 1, right = maxPlie;//速度的范围
        int speed;//相当于mid
        while(left < right){//不能带等于号，否则会陷入死循环
            speed = left + (right - left) / 2;
            if(getTime(piles, speed) > h){
                left = speed + 1;
            }else{
                right = speed;
            }
        }
        //left和right最终会重叠，此时left和right指向同一个元素，此时就是最小的速度。
        //返回left或者right都行
        return left;
    }

    public static int getTime(int piles[], int speed){
        int time = 0;
        for (int pile : piles) {
            // (pile / speed上取整)
            if(pile % speed == 0){
                time += pile / speed;
            }else{
                time += pile / speed + 1;
            }
        }
        return time;
    }


}
