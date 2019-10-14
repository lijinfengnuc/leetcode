/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: MaxArea_11 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 17:00 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class MaxArea_11 {

    public static void main(String[] args) {
        MaxArea_11 solution = new MaxArea_11();
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(array));
    }

    /** 问题可以分解为如下
     *  maxArea[n] = max(area[0,n],area[1,n]...area[n-1,n],maxArea[n-1])
     *  需要数组保存maxArea*/
    public int maxArea(int[] height) {
        int maxArea = Math.min(height[0], height[1]);
        for(int i = 2; i < height.length; i++) {
            for(int j =0; j < i; j++) {
                maxArea = Math.max(Math.min(height[j], height[i]) * (i-j), maxArea);
            }
        }
        return maxArea;
    }



}
