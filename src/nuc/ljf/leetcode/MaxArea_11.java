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

    public int maxArea(int[] height) {
        int max=0,v=0,i=0,j=height.length-1;
        while(i<j){
            if(height[i]<height[j]){
                v=height[i]*(j-i);
                i++;
            }
            else {
                v=height[j]*(j-i);
                j--;
            }
            if(v>max)
                max=v;
        }
        return max;
    }



}
