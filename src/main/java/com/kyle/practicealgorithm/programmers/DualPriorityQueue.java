package com.kyle.practicealgorithm.programmers;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*프로그래머스 > 힙 > 이중우선순위큐
문제 설명
이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

명령어	수신 탑(높이)
I 숫자	큐에 주어진 숫자를 삽입합니다.
D 1	큐에서 최댓값을 삭제합니다.
D -1	큐에서 최솟값을 삭제합니다.


풀이방향
모든 값들을 우선순위 큐에 넣은 후 결과를 리턴하면 되는 것 같다.
최대 최소에 따라 정렬하여 값을 빼면 된다.
입력은 과 추출은 I 와 D로 구분해야하는건가?



* */
public class DualPriorityQueue {

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        //정렬하여 I 입력을 처리 한 후 제어를 하도록 하자.
        //I, D 1, D-1 순으로 정렬되어 최대값 제거 후 최소값 제거하도록 하자
        PriorityQueue<Integer> increaseQueue = new PriorityQueue<>();
        PriorityQueue<Integer> decreaseQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            if (operation.startsWith("I")){
                increaseQueue.offer(Integer.parseInt(operation.substring(2)));
                decreaseQueue.offer(Integer.parseInt(operation.substring(2)));
            }else {
                if (decreaseQueue.size() < 1) {
                    continue;
                }
                if (operation.substring(2).equals("1")){
                    int max = decreaseQueue.poll();
                    increaseQueue.remove(max);
                }else {
                    int min = increaseQueue.poll();
                    decreaseQueue.remove(min);
                }
            }
        }

        if (increaseQueue.peek() == null) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        answer[0] = decreaseQueue.peek();
        answer[1] = increaseQueue.peek();

        return answer;
    }

    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(operations)));

    }
}
