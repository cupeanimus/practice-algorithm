package com.kyle.practicealgorithm.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    //오히려 더 느리다
    public static int[] twoSum2(int[] nums, int target) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int[] answer = new int[2];
        int[] sortedIndex = new int[2];

        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        loop :
        for (int i = 0; i < sortedNums.length-1; i++) {
            for (int j = i+1; j < sortedNums.length; j++) {
                if (sortedNums[i] + sortedNums[j] == target ) {
                    sortedIndex[0] = i;
                    sortedIndex[1] = j;
                    break loop;
                }
                if (sortedNums[i] + sortedNums[j] > target){
                    break;
                }
            }
        }
        answer[0] = numList.indexOf(sortedNums[sortedIndex[0]]);
        answer[1] = numList.lastIndexOf(sortedNums[sortedIndex[1]]);
        Arrays.sort(answer);

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
