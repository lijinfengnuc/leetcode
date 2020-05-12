/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q97 <br/>
 * Function: <br/>
 * Date: 2020年05月12日 16:07 <br/>
 *
 * @author lijinfeng
 */

public class Q97 {

    public static void main(String[] args) {
        Q97 q = new Q97();
        System.out.println(q.isInterleave("ab", "bc", "babc"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        if(chars1.length + chars2.length != chars3.length) {
            //长度不对，失败返回
            return false;
        }

        //dp[i][j]表示s1[0,i]与s2[0,j]是否构成了交错字符串s3[0,i+j]
        boolean[][] dp = new boolean[chars1.length+1][chars2.length+1];
        for(int i = 0; i < chars1.length+1; i++) {
            for(int j = 0; j < chars2.length+1; j++) {
                if(i==0 && j==0) {
                    //00默认为true，跳过
                    dp[0][0] = true;
                    continue;
                }
                if(i>0 && chars1[i-1] == chars3[i+j-1] && dp[i-1][j]) {
                    //由同一列上方一位推导出来
                    dp[i][j] = true;
                    continue;
                }
                if(j>0 && chars2[j-1] == chars3[i+j-1] && dp[i][j-1]) {
                    //由同一行前方一位推导出来
                    dp[i][j] = true;
                    continue;
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }

}
