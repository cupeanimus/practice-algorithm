package com.kyle.practicealgorithm.programmers;

/*
* 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
*
* 가장 간단한 것은 이중포문을 돌면서 하나씩 검사해보는 것이다. 제일먼저 이게 떠오른다.
* 두번째로는 정렬하여 뒤에 사용되는지 확인해보는 것이다
* 스트링 정렬에 대해 확신이 없으나 이는 예제를 통해 확인하였다
* 마지막으로 해시에 맞게
* 해시에 각 케이스를 저장하고 있는지 체크하는 것이다
* 해시라 해서 꼭 해시가 들어간 셋이나 맵을 쓸 필요가 없다
* 중요한 것은 해시의 개념이다.
* 다른 예제드를 보면 기존의 값 그대로 비교하고있다.
* 문제 해석을 좀 더 넓게 보려 노력해야겠다*
* */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PhoneNumberList {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        Set<String> phoneBook = new HashSet<>();
        for (String s : phone_book) {
            phoneBook.add(s);
        }

        loop :
        for (String s : phone_book) {
            for (int i = 0; i < s.length()-1; i++) {
                if (phoneBook.contains(s.substring(0,i+1))){
                    answer = false;
                    break loop;
                }
            }
        }

        return answer;
    }
    //이중포문은 피할 수 없나보다
    //깔끔하다
    public boolean solution2(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }

    //정렬한 후 뒤에 번호가 앞에 있다면 false를 던진다
    //여기서도 contains가 아닌 startWith가 되어야하지 않나 싶다
    public boolean solution3(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
//            if (phoneBook[i+1].startsWith(phoneBook[i])) {
            if (phoneBook[i+1].contains(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }





    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));

    }
}
