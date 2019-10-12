/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.leetcode;

/**
 * ClassName: FindMedianSortedArrays_4 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 10:05 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class FindMedianSortedArrays_4 {

    public static void main(String[] args) {
        FindMedianSortedArrays_4 solution = new FindMedianSortedArrays_4();
        int[] array1 = {1,4};
        int[] array2 = {2,3};
        System.out.println(solution.findMedianSortedArrays(array1, array2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        boolean isEven = length % 2 == 0;
        int middle = length/2 + 1;
        int nums1Index = 0;
        int nums2Index = 0;
        int sum = 0;
        int currentItem;
        for(int i = 0; i < middle; i++) {
            if(nums1Index >= nums1.length){
                currentItem = nums2[nums2Index];
                nums2Index++;
            }else if(nums2Index >= nums2.length){
                currentItem = nums1[nums1Index];
                nums1Index++;
            }else{
                if(nums1 [nums1Index] < nums2 [nums2Index]) {
                    currentItem = nums1[nums1Index];
                    nums1Index++;
                }else{
                    currentItem = nums2[nums2Index];
                    nums2Index++;
                }
            }
            if((isEven && i == middle - 2) || i == middle -1) {
                sum = sum + currentItem;
            }
        }
        return isEven ? ((double) sum)/2.0 : sum;
    }

}
