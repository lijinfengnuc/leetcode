/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.Arrays;

/**
 * ClassName: ThreeSumClosest_16 <br/>
 * Function: <br/>
 * Date: 2019年10月18日 16:57 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class ThreeSumClosest_16 {

    public static void main(String[] args) {
        int[] array = {-1,-2,0,1,2,3};
        ThreeSumClosest_16 solution = new ThreeSumClosest_16();
        System.out.println(solution.threeSumClosest(array, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        if(nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int left, right, currentTarget;
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            currentTarget = target - nums[i];
            left = i + 1;
            right = length - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == currentTarget) {
                    return 0;
                }else{
                    if(Math.abs(result) > Math.abs(currentTarget - sum)) {
                        result = sum + nums[i];
                    }
                    if(sum < currentTarget) {
                        while(left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        left++;
                    }else{
                        while(left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }

        }
        return result;
    }

}
