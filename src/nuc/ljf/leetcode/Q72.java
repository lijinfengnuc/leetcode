/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q72 <br/>
 * Function: <br/>
 * Date: 2020年04月30日 15:43 <br/>
 *
 * @author lijinfeng
 */

public class Q72 {

    public static void main(String[] args) {
        Q72 q = new Q72();
        System.out.println(q.minDistance("intention", "execution"));
    }

    public int minDistance(String word1, String word2) {
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        //dp[i][j]表示word1[0,i]转换成word[0,j]需要的最少操作数
        int[][] dp = new int[word1Chars.length+1][word2Chars.length+1];
        //dp[0][0]默认为0，无需初始化
        //处理第一行
        for(int i=1; i<word1Chars.length+1; i++) {
            dp[i][0] = i;
        }
        //处理第一列
        for(int j=1; j<word2Chars.length+1; j++) {
            dp[0][j] = j;
        }
        //处理剩下的行列
        for(int i=1; i<word1Chars.length+1; i++) {
            for(int j=1; j<word2Chars.length+1; j++) {
                if(word1Chars[i-1] == word2Chars[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                }
            }
        }
        return dp[word1Chars.length][word2Chars.length];
    }

}
