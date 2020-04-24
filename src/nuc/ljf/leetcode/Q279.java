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
        System.out.printf("%d", q.numSquares(9));
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<n+1; i++) {
            dp[i] = i;
            for(int j=1; j<i && j*j<=n; j++) {
                int jj = j*j;
                if(i>=jj) {
                    dp[i] = Math.min(dp[i], dp[i-jj] + 1);
                }
            }
        }
        return dp[n];
    }

}
