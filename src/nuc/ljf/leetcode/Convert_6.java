/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: Convert_6 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 10:09 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class Convert_6 {

    public static void main(String[] args) {
        Convert_6 solution = new Convert_6();
        System.out.println(solution.convert("abcdefgh",3));
    }

    public String convert(String s, int numRows) {
        if(null == s || s.trim().length() == 0){
            return "";
        }
        if(numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int sLength = s.length();
        int zLength = 2*numRows - 2;
        int cycleSize = sLength%zLength == 0 ? sLength/zLength : sLength/zLength + 1;
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < cycleSize; j++){
                int index = j*zLength+i;
                if(i == 0){
                    sb.append(s.charAt(index));
                }else{
                    if(index < sLength){
                        sb.append(s.charAt(index));
                        if(i != numRows-1){
                            int anotherIndex = (j+1)*zLength-i;
                            if(anotherIndex < sLength){
                                sb.append(s.charAt(anotherIndex));
                            }
                        }
                    }
                }

            }
        }
        return sb.toString();
    }

}
