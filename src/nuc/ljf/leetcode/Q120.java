/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: Q120 <br/>
 * Function: <br/>
 * Date: 2020年05月14日 16:59 <br/>
 *
 * @author lijinfeng
 */

public class Q120 {

    public static void main(String[] args) {
        Q120 q  = new Q120();
        List<List<Integer>> triangle = new ArrayList<>();
        Integer[][] array = {{-1},{3,2},{-3,1,-1}};
        for(Integer[] item : array) {
            triangle.add(Arrays.asList(item));
        }
        System.out.println(q.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if(size == 0) {
            return 0;
        }
        //dp[i][j]表示从0到达triangle[i][j]的最小路径和
        int[][] dp  = new int[size][size];
        int i = 0;
        for(List<Integer> list : triangle) {
            int j = 0;
            for(Integer num : list) {
                if(i==0) {
                    //0跳过
                    dp[0][0] = num;
                    continue;
                }
                //获取当前点的最小路径
                dp[i][j] = Integer.MAX_VALUE;
                if(j!=0) {
                    //左上
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + num);
                }
                if(j!=i) {
                    //上方
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + num);
                }
                j++;
            }
            i++;
        }
        return Arrays.stream(dp[size-1]).min().orElse(0);
    }

}
