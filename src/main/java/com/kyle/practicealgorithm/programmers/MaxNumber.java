package com.kyle.practicealgorithm.programmers;

import java.util.*;

/*
* 가장 큰 수
문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
*
* 풀이방향. 각 앞자리가 가장 큰 순으로 정렬하여 더하면 될 것 같다
* 이렇게 하려면 두개의 공간이 필요한데 number를 스트링으로 변환 정렬 이후 더하는것도 괜찮아보여 이 방법으로 해결해보려한다
*
* sort를 하면 10 이 1 보다 큰 수가 되어 110이 아닌 101이 된다.
* 두가지가 떠오른다 정렬을 수정할 것인가
* 각 수의 조합으로 최대값을 반환할 것인가?
*
* 또 떠오른 방향* 정렬된 값들 중 뒤에 0이 있다면 바로 뒤 숫자와 비교하여 순서를 바꾼다
* 혹은 1~9까지 각 공간을 만들고 정렬한 후 조합한다
*
* comparator로 두 조합이 큰 값으로 정렬을 하였다. comparator 사용이 아직 익숙하지 않는데 익숙해질 필요가 있다.
*
* */
public class MaxNumber {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] stringNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length ; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, new Comparator<String>() {
            //1인 값이 먼저 오게된다.
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1+o2);
            }
        });
        for (String stringNumber : stringNumbers) {
            answer+=stringNumber;
        }
        if (answer.startsWith("0")){
            return "0";
        }

        return answer;
    }

    //결국은 모두 sort를 어떻게 하느냐다
    public String solution2(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        String result = solution(numbers);
        System.out.println(result);
    }

}
