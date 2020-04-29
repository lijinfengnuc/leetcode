/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q30 <br/>
 * Function: <br/>
 * Date: 2020年04月29日 11:28 <br/>
 *
 * @author lijinfeng
 */

public class Q32 {

    public static void main(String[] args) {
        Q32 q = new Q32();
        System.out.println(q.longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len == 0) {
            return 0;
        }
        int max = 0;
        char[] chars = s.toCharArray();
        //dp[i]表示以表示以s[i]结尾的最长有效括号的长度
        int[] dp = new int[len];
        for(int i = 1; i < len; i++) {
            //结尾是(直接跳过，一定为0
            if(chars[i] == '(') {
                continue;
            }
            //求dp[i]，有两种情况，一种是s[i-1]与s[i]构成单独有效括号，另一种是s[j-1] s[j,i-1] s[i]构成嵌套有效括号
            //chars[i-1]=='('是dp[i-1]==0的充分不必要条件
            if(chars[i-1]=='(') {
                //单独有效括号
                //由于i可能小于2，需要进一步判断
                dp[i] = (i<2 ? 0 : dp[i-2]) + 2;
            }else if(dp[i-1] != 0) {
                //嵌套有效括号
                //由于条件充分不必要，因此要进一步判断
                //如果dp[i-1]==0则必不可能为嵌套有效括号
                //chars[first]为与chars[i]相匹配的字符
                int first = i-1-dp[i-1];
                if(first>=0 && chars[first] == '(') {
                    //满足嵌套有效括号条件
                    //由于当前的有效括号s[first,i]前面可能紧邻另一个有效括号，因此需要进一步判断
                    dp[i] = first>1 && dp[first-1]!=0 ? dp[first-1] + dp[i-1] + 2 : dp[i-1] + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
