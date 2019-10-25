/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: FourSum <br/>
 * Function: <br/>
 * Date: 2019年10月23日 11:45  <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class FourSum_18 {

    public static void main(String[] args) {
        int[] array = {1,0,-1,0,-2,2};
        FourSum_18 solution = new FourSum_18();
        System.out.println(solution.fourSum(array, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == nums || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int currentTarget, left, right, sum;
        for(int i = 0; i < length - 3 && nums[i] + nums[i+1] + nums[i+2] + nums[i+3] <= target; i++) {
            if((i > 0 && nums[i] == nums[i-1]) || nums[i] + nums[length-1] + nums[length-2] + nums[length-3] < target) {
                continue;
            }
            for(int j = i + 1; j < length - 2 && nums[i] + nums[j] + nums[j+1] + nums[j+2] <= target; j++) {
                if((j > i + 1 && nums[j] == nums[j-1]) || nums[i] + nums[j] + nums[length-1] + nums[length-2] < target) {
                    continue;
                }
                currentTarget = target - nums[i] - nums[j];
                left = j + 1;
                right = length - 1;
                while(left < right) {
                    sum = nums[left] + nums[right];
                    if(sum == currentTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum < currentTarget) {
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }

}
