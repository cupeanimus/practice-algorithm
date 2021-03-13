package com.kyle.practicealgorithm.programmers;

import java.util.Arrays;

public class HIndex {
/*프로그래머스 정렬 H-Index 문제
*H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
*
* 반복문으로 풀 수 있을 문제인데 정렬에 있는 것을 보면 h번 이상이라는 기준이 있어서 정렬하여 문제를 해결하여 빠른 연산이 가능하도록 하는 문제로 받아들여진다
*
* 정렬한 인덱스 기준 값으로 비교하여 구하면 될 것 같다.
* */
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length -i;

            if (citations[i]>=h){
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};

        System.out.println(solution(citations));

    }
}
