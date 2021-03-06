/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.*;

/**
 * ClassName: ThreeSum_15 <br/>
 * Function: <br/>
 * Date: 2019年10月16日 13:25 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class ThreeSum_15 {

    public static void main(String[] args) {
        int[] array = {-1,0,1,2,-1,-4};
        ThreeSum_15 solution = new ThreeSum_15();
        System.out.println(solution.threeSum(array));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        if(nums[0] > 0 || nums[length-1] < 0) {
            return result;
        }
        int left, right, currentTarget;
        for(int i = 0; i < length - 2 && nums[i] + nums[i+1] + nums[i+2] <= 0; i++) {
            if((i > 0 && nums[i] == nums[i-1]) || nums[i] + nums[length-1] + nums[length-2] < 0) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            currentTarget = 0 - nums[i];
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == currentTarget){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum < currentTarget){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }

}
