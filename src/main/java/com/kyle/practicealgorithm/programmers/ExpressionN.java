package com.kyle.practicealgorithm.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ExpressionN {

    private static int n;
    private static int target;
    private static int answer = 9;



    private static int solution2(int N, int number) {
        n = N;
        target = number;
        searchMinTarget(0, 0);

        return answer > 8 ? -1 : answer;

    }

    private static void searchMinTarget(int count, int prev) {
        if (count > 8){
            answer = -1;
            return;
        }

        if (prev == target){
            answer = Math.min(answer, count);
            return;
        }

        int tempN = n;
        for (int i = 0; i < 8 - count; i++) {
            int newCount = count + i + 1;
            searchMinTarget(newCount, prev + tempN);
            searchMinTarget(newCount, prev - tempN);
            searchMinTarget(newCount, prev / tempN);
            searchMinTarget(newCount, prev * tempN);

            tempN = tempN * 10 + n;

        }

    }


    //55, 555 고려하지 못함  <- 리스트를 중복없게하기위해 set타입으로 바꿔보자
    public static int solution(int N, int number){
        int answer = 1;

        List<Integer> resultList = new ArrayList<>();
        resultList.add(N);

        List<Integer>  repeatedNum = new ArrayList<>();
        repeatedNum.add(N);
        for (int i = 1; i < 8; i++) {
            repeatedNum.add((int) (repeatedNum.get (i-1)+Math.pow(10,i)*N));
        }



        while ( answer < 9){
            if (resultList.contains(number)) {
                return answer;
            }
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
//        int result = solution(2,11);
//        System.out.println(result);
        int result = solution2(2,11);
        System.out.println(result);

    }



}
