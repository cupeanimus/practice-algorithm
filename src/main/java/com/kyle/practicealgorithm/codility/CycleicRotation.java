package com.kyle.practicealgorithm.codility;

import java.util.Arrays;

public class CycleicRotation {
    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int length = A.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[(i+K)%length] = A[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 8, 9, 7, 6};
        int K = 3;
        System.out.println(Arrays.toString(solution(A,K)));

    }
}
