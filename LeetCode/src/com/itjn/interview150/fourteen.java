package com.itjn.interview150;

import java.util.Arrays;

public class fourteen {
    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(s);
    }

    //方法一：横向扫描：我的做法
    public static String longestCommonPrefix(String[] strs) {
        String maxprefix = strs[0];
        for (int i = 0; i < strs.length - 1; i++) {
            if(maxprefix.length() == 0)
                return "";
            maxprefix = LCP(maxprefix, strs[i + 1]);
        }
        return maxprefix;
    }

    public static String LCP(String str1, String str2){
        StringBuffer prefix = new StringBuffer();
        int length1 = str1.length();
        int length2 = str2.length();
        int j = 0;
        for (int i = 0; i < length1; i++) {
            if(j == length2)break;
            if(str1.charAt(i) == str2.charAt(j)){
                prefix.append(str1.charAt(i));
            }else{
                break;
            }
            j++;
        }
        return prefix.toString();
    }

    //方法二：横向扫描：官方解法(时间复杂度更低)
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    //方法三：先排序后判断首尾
    public String longestCommonPrefix2(String[] strs) {
        //排序
        Arrays.sort(strs);
        String prefix = longestCommonPrefix(strs[0], strs[strs.length - 1]);
        return prefix;
    }

    //方法四：纵向扫描
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
