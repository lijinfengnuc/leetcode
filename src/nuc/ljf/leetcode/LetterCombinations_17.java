/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.*;

/**
 * ClassName: LetterCombinations_17 <br/>
 * Function: <br/>
 * Date: 2019年10月22日 21:07 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class LetterCombinations_17 {

    public static void main(String[] args) {
        LetterCombinations_17 solution = new LetterCombinations_17();
        System.out.println(solution.letterCombinations("5678"));
    }

    private static char[] letterMap = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
            'o','p','q','r','s','t','u','v','w','x','y','z'};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(null == digits || digits.isEmpty()){
            return result;
        }
        int num, beginIndex, endIndex, size;
        for(int i = 0; i < digits.length(); i++) {
            num = Character.getNumericValue(digits.charAt(i));
            beginIndex = num > 7 ? 3*(num-2) + 1: 3*(num-2);
            endIndex = num == 7 || num == 9 ? beginIndex + 4 : beginIndex + 3;
            size = result.size();
            while(beginIndex < endIndex) {
                if(i == 0) {
                    result.add(Character.toString(letterMap[beginIndex]));
                }else{
                    for(int k = 0; k < size; k++) {
                        if(beginIndex == endIndex - 1) {
                            result.set(k, result.get(k) + letterMap[beginIndex]);
                        }else{
                            result.add(result.get(k) + letterMap[beginIndex]);
                        }
                    }
                }
                beginIndex++;
            }
        }
        return result;
    }

}
