/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q62 <br/>
 * Function: <br/>
 * Date: 2020年04月30日 11:32 <br/>
 *
 * @author lijinfeng
 */

public class Q62 {

    public static void main(String[] args) {
        Q62 q = new Q62();
        System.out.println(q.uniquePaths(3,2));
    }

    public int uniquePaths(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }
        //dp[i][j]表示从(0,0)到(i,j)一共有多少条路径
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 || j==0) {
                    //第一行、第一列只可能是1
                    dp[i][j] = 1;
                }else {
                    //当前路径条数=左侧路径条数+上方路径条数
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

}
