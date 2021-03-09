package com.kyle.practicealgorithm.programmers;

//초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
//
//        제한사항
//        prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
//        prices의 길이는 2 이상 100,000 이하입니다.
//        입출력 예
//        prices	return
//        [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
//        입출력 예 설명
//        1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
//        2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
//        3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
//        4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
//        5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
//        ※ 공지 - 2019년 2월 28일 지문이 리뉴얼되었습니다.

import java.util.Arrays;
import java.util.Stack;

//Stack 문제
public class StockPrice {



    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = prices.length - 2; i >= 0; i--) {

            //앞의 가격이 더 클 경우 일수는 1,
            //앞으로 비교하게 될 값
            if (prices[i] > prices[i+1]){
                answer[i] = 1;
                int[] lowerPriceAndIdx = new int[] { prices[i+1],i+1};
                stack.push(lowerPriceAndIdx);
            } else {
                //앞이 더 낮은 경우 뒤에 나오는 낮은 가격과 비교 <- 저장된 스택과 비교
                while (!stack.isEmpty() && prices[i] <= stack.peek()[0]) {
                    //이후 이 값이 최저가격 기준이 될 것이기 때문에 고려하지 않아도 될 현재보다 큰 값들은 삭제
                    stack.pop();
                }

                //stack이 비었다는 것은 현재 가격이 가장 작은 것!
                if (stack.isEmpty()){
                    answer[i] = prices.length - i -1;
                } else {    //stack까지 일수
                    answer[i] = stack.peek()[1] - i;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {1,2,3,2,1,2};
        int[] result = solution(prices);
        System.out.println(Arrays.toString(result));


    }


}
