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
}
