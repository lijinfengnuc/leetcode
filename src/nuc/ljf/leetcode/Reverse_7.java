/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Reverse_7 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 11:29 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class Reverse_7 {

    public static void main(String[] args) {
        Reverse_7 solution = new Reverse_7();
        System.out.println(solution.reverse(1534236469));
    }

    public int reverse(int x) {
        long result = 0;
        while(x != 0) {
            result = result*10 + x%10;
            x = x/10;
        }
        return result <= Integer.MAX_VALUE && result >= Integer.MIN_VALUE ? (int)result : 0;
    }

}
