package com.company.train1;

import java.util.HashMap;

/**
 * @author cz
 * @Description     滑动窗口法 相当于队列
 *                   进队列 出队列的操作
 * @date 2021/12/16 10:52
 **/
public class No3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int count = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                // s="abba"   到第二个a时候 left会回溯到第一个a的下一个位置  所以要加一个 max操作
//                left = hashMap.get(s.charAt(i))+1;
                left = Math.max(left, hashMap.get(s.charAt(i))+1);
            }
            hashMap.put(s.charAt(i), i);
            count = Math.max(count, i - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        No3 no3 = new No3();
        String s = new String();
        s="abba";
        no3.lengthOfLongestSubstring(s);
    }
}
