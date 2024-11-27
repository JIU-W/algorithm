package com.itjn.leetCode75;

public class threeHundredAndFortyFive {
    public static void main(String[] args) {
        String s = reverseVowels("ai");
        System.out.println(s);
    }

    //同样是双指针(写法更为简洁)
    public String reverseVowels1(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(arr[j])) {
                --j;
            }
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    //双指针
    public static String reverseVowels(String s) {
        StringBuffer sb = new StringBuffer(s);
        int j = s.toCharArray().length - 1;
        int i = 0;
        while(i < j){
            if( pd(sb.charAt(i)) && pd(sb.charAt(j))){
                char temp = sb.charAt(i);
                sb.setCharAt(i,sb.charAt(j));
                sb.setCharAt(j,temp);
                i++;
                j--;
            }
            if(!pd(sb.charAt(i))){
                i++;
            }
            if (!pd(sb.charAt(j))) {
                j--;
            }
        }

        return sb.toString();
    }

    public static boolean pd(char ch){
        return "aoeiuAOEIU".indexOf(ch) >= 0;
    }

}
