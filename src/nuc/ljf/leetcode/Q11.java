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

public class Q11 {

    public static void main(String[] args) {
        Q11 solution = new Q11();
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(array));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int currentArea = 0;
        //双指针分别从头尾向中间靠拢，直至相逢
        for(int i=0,j=height.length-1; i<j;) {
            if(height[i] < height[j]) {
                currentArea = height[i]*(j-i);
                i++;
            }else {
                currentArea = height[j]*(j-i);
                j--;
            }
            max = Math.max(max, currentArea);
        }
        return max;
    }

}
