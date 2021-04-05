package com.kyle.practicealgorithm.other;

import java.util.Arrays;

public class combination {

   static int[] finalPick = new int[4];


    //백트레킹
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);

            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }


    //재귀
    static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r);
    }


    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                finalPick[i] = 1;
//                System.out.print(arr[i] + " ");
            }
        }
        System.out.println("combination"+ Arrays.toString(finalPick));
        finalPick = new int[4];
//        System.out.println();
    }


    public static void main(String[] args) {

        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];

//        for (int i = 1; i <= n; i++) {
//            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
//            comb(arr, visited, 0, n, i);
//        }

        for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");

            combination(arr, visited, 0, n, i);
        }

    }

}
