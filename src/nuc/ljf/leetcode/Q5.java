/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Q5 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 10:07 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class Q5 {

    public static void main(String[] args) {
        Q5 solution = new Q5();
        System.out.println(solution.longestPalindrome("aab"));
    }

    public String longestPalindrome(String s) {
        int maxLen = 0, start = 0;
        char[] chars = s.toCharArray();
        /*中心扩散法*/
        for(int i = 0; i < chars.length; i++) {
            int l = i - 1;
            int r = i + 1;
            /*向一侧扩散寻找与中心节点相同的字符*/
            /*无需两侧都处理相同字符，后续的中心节点会检测到这种情况，当前中心节点只需向一侧扩散寻找相同字符（左右均可）*/
            while(r < chars.length && chars[i] == chars[r]){
                r++;
            }
            /*相同字符处理完，同时向两侧扩散*/
            while(l >= 0 && r < chars.length && chars[l] == chars[r]) {
                l--;
                r++;
            }
            int len = r-l-1;
            if(maxLen < len){
                start = l + 1;
                maxLen = len;
            }
        }
        return s.substring(start, start+maxLen);
    }

    public String longestPalindrome1(String s) {
        int start = 0;
        int maxLen = 0;
        char[] chars = s.toCharArray();
        //0到n的最长回文子串 = max(0到n-1的最长回文子串 + max(以n结尾的回文子串))
        for(int i=1; i<s.length()+1; i++) {
            for(int j=i; j>maxLen; j--) {
                int begin = i-j;
                int end = i-1;
                while(begin < end && chars[begin]==chars[end]) {
                    begin++;
                    end--;
                }
                if(begin==end || begin-end==1) {
                    start = i-j;
                    maxLen = j;
                    break;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

}
