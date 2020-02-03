/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.*;

/**
 * ClassName: IsValid_20 <br/>
 * Function: <br/>
 * Date: 2019年10月25日 16:33 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class IsValid_20 {

    private static Map<Character, Character> map = new HashMap<>();

    static{
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public static void main(String[] args) {
        IsValid_20 solution = new IsValid_20();
        System.out.println(solution.isValid("()"));
    }

    public boolean isValid(String s) {
        int length = s.length();
        if(length == 0){
            return true;
        }
        if(length % 2 != 0) {
            return false;
        }
        if(s.charAt(0)  == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }
        if(s.charAt(length-1)  == '(' || s.charAt(length-1) == '[' || s.charAt(length-1) == '{') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Character leftC;
        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else{
                if(stack.isEmpty()) {
                    return false;
                }
                leftC = map.get(c);
                if(stack.pop() != leftC) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
