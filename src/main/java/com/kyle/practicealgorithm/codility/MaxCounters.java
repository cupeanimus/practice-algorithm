package com.kyle.practicealgorithm.codility;

import java.util.Arrays;

public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        int[] anwser = new int[N];
        int temp = 0;
        int max = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] > N){
                max = temp;
                continue;
            }
            if (anwser[A[i] - 1] < max){
                anwser[A[i] - 1] = max;
            }

            anwser[A[i] -1]++;

            if (anwser[A[i] -1] > temp){
                temp = anwser[A[i] -1];
            }
        }

        for (int i = 0; i < N; i++) {
            if (anwser[i] < max){
                anwser[i] = max;
            }

        }

        return anwser;
    }

    public static void main(String[] args) {

        int N = 5;
        int[] A = new int[]{3,4,4,6,1,4,4};
        System.out.println(Arrays.toString(solution(N, A)));
    }
}
