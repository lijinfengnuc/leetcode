/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q70 <br/>
 * Function: <br/>
 * Date: 2020年04月30日 15:34 <br/>
 *
 * @author lijinfeng
 */

public class Q70 {

    public static void main(String[] args) {
        Q70 q = new Q70();
        System.out.println(q.climbStairs(3));
    }

    public int climbStairs(int n) {
        if(n < 3) {
            return n==1 ? 1 :2;
        }
        //dp[i]表示从1到i+1阶楼梯一共有多少种不同的方法
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

}
