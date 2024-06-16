package com.zlc.algorithm.sword;

/**
 * @Description: 反转字符串
 * @Author: zlc
 * @Date: 2024/3/29
 * @Version: 1.0
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if (s.length == 0 || s.length == 1) {
            return;
        }
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right--] = s[left];
            s[left++] = temp;
        }
    }

} 