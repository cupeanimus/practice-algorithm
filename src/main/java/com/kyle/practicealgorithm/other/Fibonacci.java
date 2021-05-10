package com.kyle.practicealgorithm.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Fibonacci {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputNums = input.split(" ");
        int a1 = Integer.valueOf(inputNums[0]);
        int a2 = Integer.valueOf(inputNums[1]);
        int n = Integer.valueOf(inputNums[2]);
        if(n < 3) {
            System.out.println(inputNums[n-1]);
            return;
        }
        int a3 = 0;
        for(int i = 2; i < n; i++){
            a3 = a1+a2;
            a1 = a2;
            a2 = a3;
        }
        System.out.println(a3);
    }
}
