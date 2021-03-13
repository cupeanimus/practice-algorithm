package com.kyle.practicealgorithm.programmers;

import java.util.Arrays;

/*프로그래머스 > 완전탐색 > 카펫
Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

생각해볼점 : 외곽만 갈색, 나머지는 노란색인가?
그렇다면 갈색의 개수는 2x+2y-4 이다.
노란색의 개수는 (x-2)*(y-2)이다.
또한 갈색+노란색 = x*y이다.   <<--예상대로 이 조건이 완전하다고 할 수없다.

최대 정사각형이라고 할때 x의 최대는
x = (brown+4)/2이다.

제한사항
갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.   <- 3*3 이상크기부터 시작된다
노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

* */
public class carpet {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        loop:
        for (int i = 3; i < (brown + 4) / 2; i++) {
            for (int j = 3; j <= i; j++) {
                //상자 개수와 노란색 조건으로 통과했지만 정확하지 않은 상자 개수 조건은 생략하는게 낫다(왜 여기에 쏠렸는지 모르겠다)
//                if ((yellow == (i-2)*(j-2)) && brown ==brown+yellow){
                if ((yellow == (i - 2) * (j - 2)) && brown == ((2 * i) + (2 * j) - 4)) {
                    answer[0] = i;
                    answer[1] = j;
                    break loop;
                }
            }
        }
        return answer;

    }

    //다른 사람들 정답
    //위 두식을 하나로 풀어서 코딩했
    public int[] solution2(int brown, int red) {
        int a = (brown + 4) / 2;
        int b = red + 2 * a - 4;
        int[] answer = {(int) (a + Math.sqrt(a * a - 4 * b)) / 2, (int) (a - Math.sqrt(a * a - 4 * b)) / 2};
        return answer;
    }

    //이미 하나의 크기가 정해지고 돌기때문에 하나의 포문으로도 가능했다.
    public int[] solution3(int brown, int red) {
        for (int i = 1; i <= red; i++) {
            if (red % i == 0 && (red / i + i) * 2 + 4 == brown) {
                return new int[]{red / i + 2, i + 2};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(solution(brown, yellow)));

    }
}
