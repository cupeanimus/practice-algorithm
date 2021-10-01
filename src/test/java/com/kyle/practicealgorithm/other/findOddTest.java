package com.kyle.practicealgorithm.other;


import org.junit.jupiter.api.Test;


import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class findOddTest {

    @Test
    void whileTest() {
        int i = 0;
        while (i < 10) {
            System.out.println("false");
            i++;
        }
    }



    @Test
    public void test(){
        assertEquals(5, findIt(new int[]{0,20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(5, FindOdd.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, FindOdd.findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals(5, FindOdd.findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, FindOdd.findIt(new int[]{10}));
        assertEquals(10, FindOdd.findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, FindOdd.findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }

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