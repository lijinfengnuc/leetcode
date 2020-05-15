/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.Arrays;

/**
 * ClassName: Q121 <br/>
 * Function: <br/>
 * Date: 2020年05月15日 14:26 <br/>
 *
 * @author lijinfeng
 */

public class Q121 {

    public static void main(String[] args) {
        Q121 q = new Q121();
        int[] array = {7,1,5,3,6,4};
        System.out.println(q.maxProfit(array));
    }

    public int maxProfit(int[] prices) {
        //股票最大利润
        int maxProfit = 0;
        //股票售价的最小值
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

}
