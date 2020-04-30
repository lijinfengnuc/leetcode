/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q85 <br/>
 * Function: <br/>
 * Date: 2020年04月30日 16:36 <br/>
 *
 * @author lijinfeng
 */

public class Q85 {

    public static void main(String[] args) {
        Q85 q = new Q85();
        char[][] array = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(q.maximalRectangle(array));
    }

    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        if(m == 0) {
            return max;
        }
        int n = matrix[0].length;
        if(n == 0) {
            return max;
        }
        //dp[i][j]表示第i行中以matrix[i][j]结尾最长连续1的个数
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                //matrix[i][j]为'0'直接跳过，一定不会有以'0'为右下角的矩形
                if(matrix[i][j] == '0') {
                    continue;
                }
                //获取dp[i][j]的值
                dp[i][j] = j==0 ? 1: dp[i][j-1] + 1;
                //获取当前行的面积
                int width = dp[i][j];
                max = Math.max(max, width);
                for(int k=i-1; k>=0; k--) {
                    //从第i行往上倒推，获取每个以matrix[i][j]为右下角的矩形的面积
                    if(dp[k][j] == 0) {
                        break;
                    }
                    width = Math.min(width, dp[k][j]);
                    max = Math.max(max, width*(i-k+1));
                }
            }
        }
        return max;
    }

}
