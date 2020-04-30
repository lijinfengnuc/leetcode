/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q53 <br/>
 * Function: <br/>
 * Date: 2020年04月30日 11:08 <br/>
 *
 * @author lijinfeng
 */

public class Q53 {

    public static void main(String[] args) {
        Q53 q = new Q53();
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(q.maxSubArray(array));
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        //dp[i]表示以i结尾的连续子数组的最大和
        int dp[] = new int[nums.length];
        int max = dp[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
