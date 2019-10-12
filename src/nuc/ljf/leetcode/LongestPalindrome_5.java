/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: LongestPalindrome_5 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 10:07 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class LongestPalindrome_5 {

    public static void main(String[] args) {
        LongestPalindrome_5 solution = new LongestPalindrome_5();
        System.out.println(solution.longestPalindrome("ababa"));
    }

    public String longestPalindrome(String s) {
        int len = 0, start = 0, end = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            int l = i - 1;
            int r = i + 1;
            while(l >= 0 && chars[l] == chars[i]){
                l--;
            }
            while(l >= 0 && r < chars.length && chars[l] == chars[r]) {
                l--;
                r++;
            }
            if(len < r-l-1){
                start = l + 1;
                end = r;
                len = end - start;
            }
        }
        return s.substring(start, end);
    }

}
