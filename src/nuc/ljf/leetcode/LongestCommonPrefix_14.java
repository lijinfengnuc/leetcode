/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: LongestCommonPrefix_14 <br/>
 * Function: <br/>
 * Date: 2019年10月16日 12:55 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        String[] strs = {"flower", "fly", "f"};
        LongestCommonPrefix_14 solution = new LongestCommonPrefix_14();
        System.out.println(solution.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }else if(strs.length == 1) {
            return strs[0];
        }else{
            String result = "";
            char currentChar;
            boolean isEqual = true;
            for(int i = 0; i < strs[0].length(); i++) {
                currentChar = strs[0].charAt(i);
                for(int j = 1; j < strs.length; j++) {
                    if(i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                        isEqual = false;
                        break;
                    }
                }
                if(!isEqual) {
                    break;
                }else{
                    result = result + currentChar;
                }
            }
            return result;
        }
    }

}
