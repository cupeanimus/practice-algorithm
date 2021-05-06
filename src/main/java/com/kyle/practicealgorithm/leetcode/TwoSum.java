package com.kyle.practicealgorithm.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        loop :
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target ) {
                    answer[0] = i;
                    answer[1] = j;
                    break loop;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] answer = twoSum(nums, 9);
        System.out.println(Arrays.toString(answer));

        int[] nums2 = new int[]{3, 2, 4, 6};
        int[] answer2 = twoSum(nums2, 6);
        System.out.println(Arrays.toString(answer2));
    }
}
