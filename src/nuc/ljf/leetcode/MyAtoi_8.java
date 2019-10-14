/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: MyAtoi_8 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 14:37 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class MyAtoi_8 {

    public static void main(String[] args) {
        MyAtoi_8 solution = new MyAtoi_8();
        System.out.println(solution.myAtoi("-123"));
    }

    public int myAtoi(String str) {
        long result = 0;
        char[] chars = str.trim().toCharArray();
        if(chars.length == 0) {
            return 0;
        }
        int i = chars[0] == '-' || chars[0] == '+' ? 1 : 0;
        boolean isNegative = chars[0] == '-';
        for(; i < chars.length; i++) {
            if(Character.isDigit(chars[i])) {
                result = result * 10 + Character.getNumericValue(chars[i]);
                if(isNegative && result - 1 > Integer.MAX_VALUE){
                    return Integer.MIN_VALUE;
                }else if(!isNegative && result > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else{
                break;
            }
        }
        return isNegative ? 0 - (int)result : (int)result;
    }

}
