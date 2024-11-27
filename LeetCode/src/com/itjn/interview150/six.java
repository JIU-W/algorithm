package com.itjn.interview150;

import java.io.BufferedWriter;
import java.util.ArrayList;

public class six {
    public static void main(String[] args) {
        String res = convert1("PAYPALISHIRING", 4);
        System.out.println(res);
    }

    //方法一：创建numRows个字符串，把字符串的单个字符逐个塞到这些字符串中。
    public static String convert(String s, int numRows) {
        //两种特殊情况
        if(numRows <= 1)return s;
        if(numRows >= s.length())return s;

        ArrayList<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            StringBuffer sb = new StringBuffer();
            rows.add(sb);
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows - 1)flag = -flag;
            i += flag;
        }

        StringBuffer res = new StringBuffer();
        for (StringBuffer row : rows)res.append(row);
        return res.toString();
    }

    //方法二：利用二维矩阵模拟
    public static String convert1(String s, int numRows) {
        int r = numRows, n = s.length();
        //特殊情况
        if(r <= 1 || r >= n)return s;

        int t = 2 * r - 2;//矩阵的周期
        int c;//矩阵的列数
        if(n % t == 0){
            c = (n / t) * (r - 1);//(n / t):周期数，(r - 1):每个周期的列数
        }else{
            c = (n / t + 1) * (r - 1);//(n / t + 1)：周期数(最后一个周期视作完整周期)
        }

        char[][] arr = new char[r][c];
        int x = 0,y = 0;
        for (int i = 0; i < n; i++) {
            arr[x][y] = s.charAt(i);
            if(i % t < r - 1){//向下移动
                x++;
            }else{//向右上移动
                x--;
                y++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (char[] chars : arr) {
            for (char ch : chars) {
                if(ch != 0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

}
