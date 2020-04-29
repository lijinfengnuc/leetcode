/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q10 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 15:57 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class Q10 {

    public static void main(String[] args) {
        Q10 q = new Q10();
        System.out.println(q.isMatch("ab", ".*c"));
    }

    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        if(p.equals(".*")) {
            return true;
        }
        int sLen = s.length();
        int pLen = p.length();
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        /*dp[i][j]表示s[0,i]与p[0,j]匹配*/
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for(int i=0; i < sLen+1; i++) {
            //dp[i][0]一定是false，无需匹配，j从1开始
            for(int j=1; j < pLen+1; j++) {
                if(pChars[j-1] == '*') {
                    //p[j-1]为*
                    //匹配0个
                    if(dp[i][j-2]) {
                        dp[i][j] = true;
                        continue;
                    }
                    //匹配1个或者多个
                    if(i > 0 && (sChars[i-1] == pChars[j-2] || pChars[j-2] == '.')) {
                        //s[i-1]与p[j-2]匹配
                        //1个 或者 多个
                        dp[i][j] = dp[i-1][j-1] || dp[i-1][j];
                    }
                }else {
                    //p[j-1]不为*
                    //匹配1个
                    if(i > 0 && (sChars[i-1] == pChars[j-1] || pChars[j-1] == '.')) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

}
