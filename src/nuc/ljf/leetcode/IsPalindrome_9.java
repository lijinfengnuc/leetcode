/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: IsPalindrome_9 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 15:15 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class IsPalindrome_9 {

    public static void main(String[] args) {
        IsPalindrome_9 solution = new IsPalindrome_9();
        System.out.println(solution.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }else if(x == 0){
            return true;
        }else{
            long result = 0;
            int num = x;
            while(num != 0){
                result = result*10 + num%10;
                num = num/10;
            }
            return result == x;
        }
    }



}
