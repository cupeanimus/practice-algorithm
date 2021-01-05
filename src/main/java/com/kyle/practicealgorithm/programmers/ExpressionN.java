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

        while ( answer < 9){
            if (resultList.contains(number)) return answer;
            int size = resultList.size();

            for (int i = 0; i < size; i++) {
                int targetNumber = resultList.get(i);
                resultList.add(targetNumber + N);
                resultList.add(targetNumber * N);
                resultList.add(targetNumber - N);
                resultList.add(targetNumber / N);
            }
            answer++;


        }

        return -1;
    }

    //sample또한 맞지 않다. 내일 수정을 해보
    public static int sampleAnswer(int n, int num) {
        int ans = 0;
        ArrayList <HashSet<Integer>> list = new ArrayList<>();
        HashSet <Integer> set = new HashSet<>();
        set.add(n);
        list.add(set);

        while(ans < 8) {
            if(list.get(ans).contains(num)) break;
            ans++;

            HashSet <Integer> nset = new HashSet<>();
            String s = "";
            for(int i = 0; i < ans + 1; i++) s += String.valueOf(n);
            nset.add(Integer.parseInt(s));

            for(int i = 0; i <= ans / 2; i++) {
                for(int j = 0; i + j < ans; j++) {
                    for(Iterator it1 = list.get(i).iterator(); it1.hasNext();) {
                        int op1 = (int)it1.next();
                        for(Iterator it2 = list.get(j).iterator(); it2.hasNext();) {
                            int op2 = (int)it2.next();
                            nset.add(op1 + op2);
                            nset.add(op1 - op2);
                            nset.add(op1 * op2);
                            if(op2 != 0) nset.add(op1 / op2);
                        }
                    }
                }
            }
            list.add(nset);
        }

        return (ans >= 8) ? -1 : ans + 1;
    }


}
