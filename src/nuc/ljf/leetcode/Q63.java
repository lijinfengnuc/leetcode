/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q63 <br/>
 * Function: <br/>
 * Date: 2020年04月30日 12:00 <br/>
 *
 * @author lijinfeng
 */

public class Q63 {

    public static void main(String[] args) {
        Q63 q = new Q63();
        int[][] array = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(q.uniquePathsWithObstacles(array));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //dp[i][j]表示从(0,0)到(i,j)一共有多少条路径
        int dp[][] = new int[m][n];
        //处理第一行
        for(int i=0; i<m; i++) {
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        //处理第一列
        for(int j=0; j<n; j++) {
            if(obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
        //处理剩下的行列
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

}
