package com.kyle.practicealgorithm.doit;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Chapter1Test {


    @Test
    void q7Test(){
        int result = q7(7);
        assertEquals(result,28);
    }

    @Test
    void q8Test(){
        int result = q8(10);
        assertEquals(result,55);
    }

    int q7(int n){
        int total = 0;
        while (n > 0){
            total += n;
            n--;
        }
        return total;
    }

    int q8(int n){
        int multiple = n/2;

        return (1+n)*n/2;

    }

    @Test
    void sortingTest(){
        String[] a = {"I 1","D 1","D -1","-1","1"};
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));
    }

    @Test
    void alphabetTest(){
        List<String> matings = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) {

            System.out.println((char)i);

        }
    }

    @Test
    void subStringTest(){
        String a= "서울27가8421";
        System.out.println(a.substring(2,4));
        System.out.println(a.substring(5,9));
    }


    @Test
    void sortTest(){
        int[][] points = {{0,0}, {4,3}, {1,1}, {2,2}};

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        System.out.println(Arrays.toString(points));


    }

    @Test
    void doubleCompareTest(){
        double a = 0.5;
        double b = 0.51;
        System.out.println(a==b);
    }


    @Test
    void listTest(){
       String s = "hello";
       List<String> stringList = Arrays.asList(s.split(""));
        System.out.println(stringList.get(0));
    }


}