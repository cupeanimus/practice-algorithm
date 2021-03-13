package com.kyle.practicealgorithm.programmers;

import org.omg.CORBA.ARG_IN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PracticeTest {
/*문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
전체를 돌면서 비교하는 수박에 떠오르지 않는다
완전탐색 분류에 들어있는 것으로 이 방법이 권장 방법인가보다
그렇다면 세 명의 답안지 패턴을 그리고 정답과 비교한 후 결과값을 리턴받고
이를 비교하여 던져주면 되겠다.
*/

    public static int[] solution(int[] answers) {
        int[] aAnswers = aAnswerGenerate(answers.length);
        int[] bAnswers = bAnswerGenerate(answers.length);
        int[] cAnswers = cAnswerGenerate(answers.length);

        int[] correctAnswers = {0,0,0};


        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == aAnswers[i]){
                correctAnswers[0] = correctAnswers[0]+1;
            }
            if (answers[i] == bAnswers[i]){
                correctAnswers[1] = correctAnswers[1]+1;
            }
            if (answers[i] == cAnswers[i]){
                correctAnswers[2] = correctAnswers[2]+1;
            }
        }

        int max = Math.max(Math.max(correctAnswers[0],correctAnswers[1]),correctAnswers[2]);
        List<Integer> maxCollectors = new ArrayList<>();
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i] == max) {
                maxCollectors.add(i);
            }
        }
        Collections.sort(maxCollectors);
        int[] answer = new int[maxCollectors.size()];

        for (int i = 0; i < maxCollectors.size(); i++) {
            answer[i] = maxCollectors.get(i)+1;
        }

        return answer;
    }

    private static int[] cAnswerGenerate(int length) {
        int[] cAnswers = new int[length];
        for (int i = 0; i < length; i++) {
            switch ((i%10)/2){
                case 0:
                    cAnswers[i] = 3;
                    break;
                case 1:
                    cAnswers[i] = 1;
                    break;
                case 2:
                    cAnswers[i] = 2;
                    break;
                case 3:
                    cAnswers[i] = 4;
                    break;
                case 4:
                    cAnswers[i] = 5;
                    break;
            }

        }
        return cAnswers;
    }

    private static int[] bAnswerGenerate(int length) {
        int[] bAnswers = new int[length];
        for (int i = 0; i < length; i++) {
            if (i%2 == 0){
                bAnswers[i] = 2;
            }else {
                switch ((i/2)%4){
                    case 0:
                        bAnswers[i] = 1;
                        break;
                    case 1:
                        bAnswers[i] = 3;
                        break;
                    case 2:
                        bAnswers[i] = 4;
                        break;
                    case 3:
                        bAnswers[i] = 5;
                        break;
                }
            }
        }
        return bAnswers;
    }

    private static int[] aAnswerGenerate(int length) {
        int[] aAnswers = new int[length];
        for (int i = 0; i < length; i++) {
            switch (i%5){
                case 0:
                    aAnswers[i] = 1;
                    break;
                case 1:
                    aAnswers[i] = 2;
                    break;
                case 2:
                    aAnswers[i] = 3;
                    break;
                case 3:
                    aAnswers[i] = 4;
                    break;
                case 4:
                    aAnswers[i] = 5;
                    break;
            }
        }
        return aAnswers;
    }

    public static void main(String[] args) {
//        int[] answers = {1,2,3,4,5};
//        System.out.println(Arrays.toString(solution(answers)));
        int[] answers2 = {1,3,2,4,2,1,2,3,4,5};
        System.out.println(Arrays.toString(solution(answers2)));

    }
}
