package com.zlc.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 数组的度数
 * @Author: zlc
 * @Date: 2024/4/2
 * @Version: 1.0
 */
public class ShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> degreeMap = new HashMap<>();
        int maxDegree = 0;
        for (int i : nums) {
            degreeMap.put(i, degreeMap.getOrDefault(i,0)+1);
            maxDegree = Math.max(maxDegree, degreeMap.get(i));
        }
        int left = 0, right = 0, length = nums.length, res = length;
        Map<Integer, Integer> resMap = new HashMap<>();
        while(right < length){
            resMap.put(nums[right], resMap.getOrDefault(nums[right],0)+1);
            right++;
            // 这里写 while(resMap.get(nums[right]) == maxDegree) 会报空指针异常, 因为上面right++了
            while(resMap.get(nums[right-1]) == maxDegree){
                resMap.put(nums[left], resMap.get(nums[left])-1);
                res = Math.min(res, right-left);
                left++;
            }
        }
        return res;
    }
}