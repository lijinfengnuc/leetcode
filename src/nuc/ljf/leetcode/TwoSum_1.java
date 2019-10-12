package nuc.ljf.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TwoSum_1 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 09:44 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class TwoSum_1 {

    public static void main(String[] args) {
        TwoSum_1 solution = new TwoSum_1();
        int[] array = {1,2,3};
        System.out.println(Arrays.toString(solution.twoSum(array, 3)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for(int j = 0; j < nums.length; j++) {
            if(null != map.get(target-nums[j]) && j != map.get(target-nums[j])) {
                result[0]=j;
                result[1]=map.get(target-nums[j]);
                break;
            }
        }
        return result;
    }

}
