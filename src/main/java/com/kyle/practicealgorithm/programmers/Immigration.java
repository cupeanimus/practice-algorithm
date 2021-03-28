package com.kyle.practicealgorithm.programmers;

import java.util.Arrays;

//시간 초과가 발생한다.
//이분 탐색문자라고 하니 이분탐색 알고리즘을 활용해보자
public class Immigration {
    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        int count = 0;
        int sec = 0;

        loop:
        while (count < n+times.length) {
            for (int i = 0; i <times.length ; i++) {
                if (sec % times[i] == 0){
                    count++;
                }
                if (count == n+times.length){
                    break loop;
                }
            }
            sec++;

        }

        return sec;
    }

    //다른 예제에 long을 사용한 것을보고 의아했는데 조건이 심사관 최대 시간이 10억분으로 초로 환산하였을때 인트 최대값을 넘어선다.
    public static long otherSolution(int n, int[] times) {
        Arrays.sort(times);
        long sec = Long.MAX_VALUE;
        long low, mid, high, sum;
        low = 0;
        high = Long.MAX_VALUE;

        while (low <= high){

            mid = (low + high) / 2;
            if (mid < 30){
                System.out.println(mid);
            }
            sum = 0;
            //해당 시간에 n명을 봤을때의 시간 중 최소값
            for (int i = 0; i <times.length ; i++) {
                //sum = 주어진 시간에 심사한 인원 수
                sum += mid / times[i];

                if (sum >= n){
                    break;
                }
            }

            if (n > sum){
                low = mid+1;
            } else {
                high = mid-1;
                sec = Math.min(sec, mid);
            }
        }


        return sec;
    }

    //반복문 이용한 이분탐색 알고리
    int BSearch(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    //재귀함수 알고리즘
   int BSearchRecursive(int arr[], int target, int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            return BSearchRecursive(arr, target, low, mid-1);
        else
            return BSearchRecursive(arr, target, mid+1, high);
    }


    public static void main(String[] args) {
        int[] times = new int[]{7,10};
        System.out.println(solution(6, times));
        System.out.println(otherSolution(6, times));

    }

}
