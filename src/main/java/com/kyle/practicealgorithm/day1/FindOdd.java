package com.kyle.practicealgorithm.day1;

import java.util.TreeSet;

public class FindOdd {
    public static int findIt(int[] a) {
        int oddInt = 0;

        TreeSet<Integer> aTreeSet = new TreeSet<>();
        for (int i : a) {
            aTreeSet.add(i);
        }

        for (Integer integer : aTreeSet) {
            if (isOdd(integer,a)){
                oddInt = integer;
            }
        }
        return oddInt;
    }

    private static boolean isOdd(Integer integer, int[] a) {
        int count =0;
        for (int i : a) {
            if (i == integer){
                count++;
            }
        }
        return count%2 != 0;
    }


    //best Solution
    //xor연산자 ->비트 연산할 때 1이 홀수면 1 짝수면 0이나오는 특징을 이용하였다.
    //아래 전체에서 배열의 모든 수를 비트연산하면 중복수는 1 짝수로 0이되므로 자연히 홀수인 수 하나만 남게되는 성질을 이용하여 해결
    public static int BestfindIt(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }

        return xor;

    }

}
