package com.itjn.leetCode75;

public class oneThousandFourHundredAndFiftySix {
    public static void main(String[] args) {
        int i = maxVowels1("rhythms", 4);
        System.out.println(i);
    }

    //定长滑动窗口
    public static int maxVowels(String s, int k) {
        int n = s.length();
        int max = 0, tempMax = 0;
        String sbs = s.substring(0, k);
        tempMax = containsVowel(sbs);
        max = tempMax;
        int i = 0, j = i + k - 1;
        while (i < n - k) {
            j++;
            tempMax += containsVowel(s.charAt(j));
            tempMax -= containsVowel(s.charAt(i));
            i++;
            max = Math.max(max, tempMax);
        }
        return max;
    }

    public static int containsVowel(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'i' || str.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }

    public static int containsVowel(char c) {
        int count = 0;
        if (c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u') {
            count++;
        }
        return count;
    }

    //二刷
    public static int maxVowels1(String s, int k) {
        int max = 0, n = s.length();
        String ss = s.substring(0, k);
        max = containsVowel(ss);
        int i = 0, j = i + k - 1;
        int sum = max;
        while (i < n - k) {
            j++;
            if (containsVowel(s.charAt(j)) == 1) {
                sum = sum + 1;
            }
            if (containsVowel(s.charAt(i)) == 1) {
                sum = sum - 1;
            }
            i++;
            max = Math.max(max, sum);
        }
        return max;
    }


}
