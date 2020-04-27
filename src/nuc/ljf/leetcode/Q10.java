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
        System.out.println(q.isMatch("aa","a"));
    }

    public boolean isMatch(String s, String p) {
        boolean sEmpty = s.isEmpty();
        boolean pEmpty = p.isEmpty();
        if(sEmpty || pEmpty) {
            return sEmpty && pEmpty;
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
        if(sChars[0] != pChars[0] && pChars[0] != '.') {
            return false;
        }
        dp[1][1] = true;
        for(int i=0; i < sLen + 1; i++) {
            for(int j=0; j < pLen + 1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = true;
                }
                if(dp[i-1][j-1]) {
                    if(sChars[i+1] == pChars[j+1]) {
                        dp[i][j] = true;
                        continue;
                    }
                    if(pChars[j+1] == '.') {
                        dp[i][j] = true;
                        continue;
                    }
                    if(sChars[i+1] == pChars[j-1] && pChars[j] == '*')

                }


                if(sChars[i+1] == pChars[j+1] || pChars[j+1] == '.' || (sChars[i+1] == pChars[j-1] && pChars[j] == '*')) {
                    dp[i+1][j+1] = true;
                }
                if(j > 0 && (sChars[i+1] == pChars[j-1] && pChars[j] == '*')) {
                    dp[i+1][j] = true;
                }
                if(pChars[j] == '*') {
                    //j加1
                    dp[i][j+1] = true;
                }
            }
        }
    }

}
