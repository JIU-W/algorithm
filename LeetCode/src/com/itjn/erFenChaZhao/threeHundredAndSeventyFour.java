package com.itjn.erFenChaZhao;

public class threeHundredAndSeventyFour {
    public static void main(String[] args) {

    }

    public int guessNumber(int n) {
        int l = 1, r = n;
        while(l <= r){
            int middle = l + ((r - l) >> 1);
            if(guess(middle) < 0){
                r = middle - 1;
            }else if(guess(middle) > 0){
                l = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    public int guess(int n){
        //。。。。。。
        return 0;
    }


}
