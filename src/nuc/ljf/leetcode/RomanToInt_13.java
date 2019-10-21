/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: RomanToInt_13 <br/>
 * Function: <br/>
 * Date: 2019年10月16日 10:33 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class RomanToInt_13 {

    public static void main(String[] args) {
        RomanToInt_13 solution = new RomanToInt_13();
        System.out.println(solution.romanToInt("MMMDCCCLXXXIX"));
    }

    private static Map<Character, Integer> map = new HashMap<>();

    static{
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }

    public int romanToInt(String s) {
        int result = 0;
        int lastValue = 0;
        int currentValue;
        for(int i = 0; i < s.length(); i++){
            currentValue = map.get(s.charAt(i));
            if(currentValue > lastValue && lastValue != 0){
                result = result + currentValue - 2*lastValue;
            }else{
                result = result + currentValue;
            }
            lastValue = currentValue;
        }
        return result;
    }

}
