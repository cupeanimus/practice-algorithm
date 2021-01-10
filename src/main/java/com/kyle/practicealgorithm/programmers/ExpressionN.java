package com.kyle.practicealgorithm.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ExpressionN {

    //55, 555 고려하지 못함
    public static int solution(int N, int number){
        int answer = 1;

        List<Integer> resultList = new ArrayList<>();
        resultList.add(N);

        List<Integer>  repeatedNum = new ArrayList<>();
        repeatedNum.add(N);
        for (int i = 1; i < 8; i++) {
            repeatedNum.add((int) (repeatedNum.get (i-1)+Math.pow(10,i)*5));
        }



        while ( answer < 9){
            if (resultList.contains(number)) return answer;
            int size = resultList.size();

            for (int i = 0; i < size; i++) {
                int targetNumber = resultList.get(i);
                resultList.add(targetNumber + N);
                resultList.add(targetNumber * N);
                resultList.add(targetNumber - N);
                resultList.add(targetNumber / N);
                resultList.add(repeatedNum.get(answer));

            }
            answer++;


        }

        return -1;
    }



    public static void main(String[] args) {
        int result = solution(5,39);
        System.out.println(result);
    }



}
