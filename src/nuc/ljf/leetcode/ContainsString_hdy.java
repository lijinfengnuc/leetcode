/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ContainsString_hdy <br/>
 * Function: <br/>
 * Date: 2019年10月31日 12:43 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class ContainsString_hdy {

    public static void main(String[] args) {
        ContainsString_hdy solution = new ContainsString_hdy();
        System.out.println(solution.containsString("sssk", "asssskl"));
    }

    public boolean containsString(String str1, String str2) {
        if(str1 == null || str2 == null) {
            return true;
        }
        if(str1.length() == 0 || str2.length() == 0) {
            return true;
        }
        int index = 0;
        int begin = 0;
        String minStr = str1.length() > str2.length() ? str2 : str1;
        String maxStr = str1.length() > str2.length() ? str1 : str2;
        for(int i = 0; i < maxStr.length() && index < minStr.length(); i++) {
            if(maxStr.charAt(i) == minStr.charAt(index)) {
                if(index == 0) {
                    begin = i;
                }
                index++;
            }else{
                if(index != 0) {
                    index = 0;
                    i = begin;
                }
            }
        }
        return index == minStr.length();
    }

}
