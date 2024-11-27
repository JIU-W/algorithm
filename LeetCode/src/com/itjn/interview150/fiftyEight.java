package com.itjn.interview150;

public class fiftyEight {
    public static void main(String[] args) {
        int i = lengthOfLastWord2("   fly me   to   the moon  ");
        System.out.println(i);
    }

    //反向遍历
    public static int lengthOfLastWord1(String s) {
        String str = new String();
        //可以借助StringBuffer翻转
        //StringBuffer sb = new StringBuffer(str);//sb.reverse().toString();
        int n = s.length();
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            //特殊情况(防止判断到字符串第一个字符是超出索引(i - 1))
            if(i == 0){
                count++;
                break;
            }
            //符合情况，累加
            if(s.charAt(i) != ' ' && s.charAt(i - 1) != ' '){// !equals()
                count++;
            }
            //字符与空格的交界处，作为出口。
            if(s.charAt(i) != ' ' && s.charAt(i - 1) == ' '){
                count++;
                break;
            }
        }
        return count;
    }

    //熟用API
    public static int lengthOfLastWord(String s) {
        return s.split(" ")[s.split(" ").length - 1].length();
    }
    //熟用API
    public static int lengthOfLastWord2(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(" ") - 1;
    }


}
