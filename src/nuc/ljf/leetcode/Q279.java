/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q279 <br/>
 * Function: <br/>
 * Date: 2020年04月19日 19:18 <br/>
 *
 * @author lijinfeng
 */

public class Q279 {

    public static void main(String[] args) {
        Q279 q = new Q279();
        System.out.printf("%d", q.numSquares(12));
    }

    public int numSquares(int n) {
        /*dp[i]表示i的最少完全平方数个数*/
        int[] dp = new int[n+1];
        for(int i=1; i<n+1; i++) {
            /*最多为i，即全由1相加*/
            dp[i] = i;
            for(int j=1; j<=i; j=j+1) {
                int jj = j*j;
                if(jj > i) {
                    /*j的平方大于i，终止j的循环*/
                    break;
                }
                /*dp[i] = max(dp[i],dp[i-jj] + 1)*/
                dp[i] = Math.min(dp[i], dp[i-jj] + 1);
            }
        }
        return dp[n];
    }

}
