package org.example.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/description/">move zeros</a>
 * <br>
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <br>
 * Note that you must do this in-place without making a copy of the array.
 * <br>
 * <br>
 * Example 1:
 * <br>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <br>
 * Example 2:
 * <br>
 * Input: nums = [0]
 * Output: [0]
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int end = nums.length;
        int index = 0;
        int[] result = new int[end];
        Arrays.fill(result, 0);
        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }
        System.arraycopy(result, 0, nums, 0, end);
    }


    public void moveZeroesFast(int[] nums) {

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

}
