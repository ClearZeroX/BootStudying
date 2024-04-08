package com.zlc.algorithm;

import java.util.HashSet;

/**
 * @Description: TODO zs
 * @Author: zlc
 * @Date: 2024/4/8
 * @Version: 1.0
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, res = 0;
        while(right < s.length()){
            char c = s.charAt(right++);
            //存在重复的字符，则移动左指针，直到滑动窗口中不含有该字符
            while(set.contains(c)){
                set.remove(s.charAt(left++));
            }
            set.add(c);
            res = Math.max(res, right-left);
        }
        return res;
    }
}