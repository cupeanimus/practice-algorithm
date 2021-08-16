package com.kyle.practicealgorithm.remoteinterview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputNums = input.split(" ");

        int answer = solution(inputNums);

        System.out.println(answer);
    }

    private static int solution(String[] inputNums) {
        int a1 = Integer.parseInt(inputNums[0]);
        int a2 = Integer.parseInt(inputNums[1]);
        int n = Integer.parseInt(inputNums[2]);
        int a3 = 0;

        if(n < 3) {
            System.out.println();
            a3 = Integer.parseInt(inputNums[n-1]);
            System.out.println(" fibo a3 : "+ a3);
            return a3;
        }
        for(int i = 2; i < n; i++){
            a3 = a1+a2;
            a1 = a2;
            a2 = a3;
        }

        return a3;
    }
}
