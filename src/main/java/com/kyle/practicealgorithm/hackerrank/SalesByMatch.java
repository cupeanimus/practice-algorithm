package com.kyle.practicealgorithm.hackerrank;

import ch.qos.logback.core.util.TimeUtil;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SalesByMatch {
    public static int sockMerchant(int n, int[] ar) {
        // Write your code here
        int pairs = 0;

        Map<Integer, Boolean> pairMap = new HashMap<>();

        for (Integer integer : ar) {
            if (pairMap.getOrDefault(integer, true)){
                pairMap.put(integer, false);
                continue;
            }
            pairs++;
            pairMap.put(integer, true);
        }

        return pairs;
    }

    //other solution
    public static int sockMerchant2(int n, int[] c) {
        // Write your code here
        Set<Integer> colors = new HashSet<>();
        int pairs = 0;

        for (int i = 0; i < n; i++) {
            if (!colors.contains(c[i])) {
                colors.add(c[i]);
            } else {
                pairs++;
                colors.remove(c[i]);
            }
        }
        return pairs;
    }

    //remove 영향인지 map을 이용한 내 풀이가 50%정도 더 빠르다.
    public static void main(String[] args) {

        int n = 214748364;
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = (i*10)%1000;
        }

        long startTime = System.currentTimeMillis();
        int result = sockMerchant(n, c);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(result);

        startTime =  System.currentTimeMillis();
        int result2 = sockMerchant2(n, c);
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(result2);




    }
}
