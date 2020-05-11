/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q91 <br/>
 * Function: <br/>
 * Date: 2020年05月11日 14:40 <br/>
 *
 * @author lijinfeng
 */

public class Q91 {

    public static void main(String[] args) {
        Q91 q = new Q91();
        System.out.println('1');
        System.out.println(q.numDecodings("101"));
    }

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        //dp[i]表示s[0,i]有多少种解码方式
        int[] dp = new int[chars.length];
        if(chars[0] == 48) {
            //无法解码
            return 0;
        }else {
            dp[0] = 1;
        }
        for(int i=1; i<chars.length; i++) {
            if(chars[i] == 48) {
                //当前字符为0
                if(chars[i-1] == 49 || chars[i-1] == 50) {
                    //与前一个字符可结合
                    dp[i] = i==1 ? 1 : dp[i-2];
                }else {
                    //无法解码
                    return 0;
                }
            }else {
                //当前字符不为0
                if(chars[i-1] == 49 || (chars[i-1] == 50 && chars[i] < 55)) {
                    //与前一个字符可结合
                    dp[i] = dp[i-1] + (i==1 ? 1 : dp[i-2]);
                }else {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[chars.length-1];
    }

}
