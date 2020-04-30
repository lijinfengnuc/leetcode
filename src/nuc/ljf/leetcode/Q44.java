/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q44 <br/>
 * Function: <br/>
 * Date: 2020年04月29日 18:43 <br/>
 *
 * @author lijinfeng
 */

public class Q44 {

    public static void main(String[] args) {
        Q44 q = new Q44();
        System.out.println(q.isMatch("aa","a"));
    }

    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int sLen = sChars.length;
        int pLen = pChars.length;
        //dp[i][j]表示s[0,i]与p[0,j]是否匹配
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for(int i=0; i<sLen+1; i++) {
            for(int j=1; j<pLen+1; j++) {
                if(pChars[j-1] == '*') {
                    //0个
                    dp[i][j] = dp[i][j-1];
                    if(!dp[i][j] && i>0) {
                        //1个或者多个
                        dp[i][j] = dp[i-1][j-1] || dp[i-1][j];
                    }
                }else {
                    //1个
                    if(i>0 && (sChars[i-1]==pChars[j-1] || pChars[j-1] == '?')) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

}
