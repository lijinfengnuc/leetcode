/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q64 <br/>
 * Function: <br/>
 * Date: 2020年04月30日 15:16 <br/>
 *
 * @author lijinfeng
 */

public class Q64 {

    public static void main(String[] args) {
        Q64 q = new Q64();
        int[][] array = {{1,2,5},{3,2,1}};
        System.out.println(q.minPathSum(array));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[][]表示从(0,0)到(i,j)的最小路径和
        int[][] dp = new int[m][n];
        //处理dp[0,0]
        dp[0][0] = grid[0][0];
        //处理第一行
        for(int i=1; i<m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //处理第一列
        for(int j=1; j<n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        //处理其他行列
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

}
