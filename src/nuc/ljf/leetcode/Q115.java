/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q115 <br/>
 * Function: <br/>
 * Date: 2020年05月12日 18:43 <br/>
 *
 * @author lijinfeng
 */

public class Q115 {

    public static void main(String[] args) {
        Q115 q = new Q115();
        System.out.println(q.numDistinct("acbce", "ace"));
    }

    public int numDistinct(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if(sChars.length == 0 || tChars.length == 0) {
            //快速失败返回
            return 0;
        }
        //dp[i][j]表示s[0,i]中t[0,j]出现的次数
        int[][] dp = new int[sChars.length+1][tChars.length+1];
        for(int i=0; i<=sChars.length; i++) {
            //将第一列初始化为1，因为若t[0]与s[i]匹配，则dp[i+1][1]需要加1
            dp[i][0] = 1;
        }
        for(int i=1; i<=sChars.length; i++) {
            //j的取值必须小于等于i，j大于i时dp[i][j]一定为0
            for(int j=1; j<=tChars.length && j<=i; j++) {
                if(sChars[i-1] == tChars[j-1]) {
                    //s[i]与t[j]匹配
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                }else {
                    //s[i]与t[j]不匹配
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[sChars.length][tChars.length];
    }

}
