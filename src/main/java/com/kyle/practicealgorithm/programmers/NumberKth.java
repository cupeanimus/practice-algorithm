package com.kyle.practicealgorithm.programmers;

import java.util.Arrays;

/* 프로그래머스 K번째 수
* 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
*
* 접근방법 : 첫 리스트를 주어진 commands에 맞춰서 자른다 ->substring이 떠올랐는데 비슷한 함수가 있는지 알아보
* 몇번째인지 구한다 -> 자른 후 솔팅 -> 스트림이나 collector, 앞 서 푼 heap등 다양한 방법이 있지만 몇 번째이기때문에 heap은 생략
* 레벨1이니 그냥 주어진 함수들로 풀면되지 않을까 싶다.
*
* */
public class NumberKth {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIdx = 0;
        for (int[] command : commands) {
            int[] tempArray = Arrays.copyOfRange(array,command[0]-1,command[1]);
            Arrays.sort(tempArray);
            answer[answerIdx] = tempArray[command[2]-1];
            answerIdx++;
        }

        return answer;
    }

    public static void main(String[] args) {
       int[] array = {1,5,2,6,3,7,4};
       int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
       System.out.println(Arrays.toString(solution(array, command)));


    }

}
