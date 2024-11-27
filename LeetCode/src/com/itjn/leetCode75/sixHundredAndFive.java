package com.itjn.leetCode75;

public class sixHundredAndFive {
    public static void main(String[] args) {
        boolean b = canPlaceFlowers(new int[]{1, 0, 0,0, 0, 1}, 2);
        System.out.println(b);
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if(flowerbed.length == 1){
            if(flowerbed[0] == 1 && n == 0)return true;
            if(flowerbed[0] == 1 && n > 0)return false;
            if(flowerbed[0] == 0 && n <= 1){
                return true;
            }else{
                return false;
            }
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if(i == 0){
                if(flowerbed[i] == 0 && flowerbed[i+1] != 1){
                    count++;
                    flowerbed[i] = 1;
                    continue;
                }
                continue;
            }
            if(i == flowerbed.length - 1){
                if(flowerbed[i] == 0 && flowerbed[i-1] != 1){
                    count++;
                    flowerbed[i] = 1;
                    break;
                }
                break;
            }
            if(flowerbed[i] == 0 && flowerbed[i-1] != 1 && flowerbed[i+1] != 1){
                count++;
                flowerbed[i] = 1;
            }
        }
        if(count >= n)return true;
        return false;
    }

}
