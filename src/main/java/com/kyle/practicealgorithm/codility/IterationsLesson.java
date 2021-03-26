package com.kyle.practicealgorithm.codility;

import java.util.HashSet;
import java.util.Set;

public class IterationsLesson {

    //53%밖에 나오지 않았다. Integer.toBinaryString(N)<< 가 문제가 되지 않았을까 생각된다.

    public static int solution(int N) {
        if (N<2){
            return 0;
        }
        while (N%2 == 0){
            N /= 2;
        }
        int answer = 0;
        int count = 0;
        while (N>0){
            if (N % 2 == 1){
                answer = count>answer?count:answer;
                count = 0;
            }else {
                count++;
            }
            N /= 2;
        }

        return answer;
    }

    public static int solution2(int N) {
        String str = Integer.toBinaryString(N);

        int count = 0;
        int answer = 0;

        for (int i = 1; i < str.length(); i++) {
            count++;
            if (str.length()-i<answer){
                break;
            }
            if (str.charAt(i) == '1'){
                if (answer != 0){
                    answer = count>answer?count:answer;
                }else {
                    answer = count-1;
                    count = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(9));
        System.out.println(solution(529));
    }

}
