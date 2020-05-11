/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Q87 <br/>
 * Function: <br/>
 * Date: 2020年04月30日 19:36 <br/>
 *
 * @author lijinfeng
 */

public class Q87 {

    public static void main(String[] args) {
        Q87 q = new Q87();
        System.out.println(q.isScramble("great","rgeat"));
    }

    public boolean isScramble(String s1, String s2) {
        if(s1.length()==0) {
            return true;
        }
        //dp[i][j]表示以s1[i]
        return true;
    }

}
