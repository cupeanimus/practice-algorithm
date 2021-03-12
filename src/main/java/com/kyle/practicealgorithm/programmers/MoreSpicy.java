package com.kyle.practicealgorithm.programmers;

import java.util.PriorityQueue;

public class MoreSpicy {
//    더 맵게
//
//    문제 설명
//    매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
//
//    섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
//    Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
//    Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
//
//    제한 사항
//    scoville의 길이는 2 이상 1,000,000 이하입니다.
//            K는 0 이상 1,000,000,000 이하입니다.
//    scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
//    모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
//            입출력 예
//    scoville	K	return
//            [1, 2, 3, 9, 10, 12]	7	2
//    입출력 예 설명
//    스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
//    새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
//    가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
//
//    스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
//    새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
//    가진 음식의 스코빌 지수 = [13, 9, 10, 12]
//
//    모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.


    //-1을 리턴하는 경우가 있나? 조건을 추가해야할 필요가 있을까?

//     [ 힙 정렬이란? ]
//
//    이진 트리에 기반한 힙 트리구조를 만들어가며 배열을 정렬시킴
//    병합정렬의 메모리 효율성 문제를 해결하면서 O(n*logN)의 시간 복잡도를 보장
//    결국 시간복잡도가 log지수의 증가를 가지려면 소그룹으로 분리시켜 정렬해나가야 함
//    소그룹으로 쪼개서 정렬하는 방법에 힙 트리(이진 트리) 구조가 적용된 방식이라 볼 수 있음
//
//   ​  [ 이진 트리란? ]
//
//    하나의 노드에 자식 노드가 2개 이하인 트리 구조
//​
//     [ 힙 트리란? ]
//
//    이진 트리 구조에서, 노드 간의 관계에 규칙성이 적용 된 구조
//    최대 힙 구조 : 부모 노드가 자식 노드보다 값이 큼 (가장 위 root 값이 최대값이 됨)
//    최소 힙 구조 : 최대 힙 구조와 반대
//    이진 트리를 최대 힙 또는 최소 힙 구조로 완성시킴 (최대값, 최소값을 빠르게 찾을 수 있음)
//

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.offer(scoville[i]);
        }

        while (queue.peek() < K) {
            if (queue.size() < 2) {
                return -1;
            }
            int lowestScoville = queue.poll();
            int secondScoville = queue.poll();
            int newScoville = lowestScoville + (secondScoville * 2);
            queue.offer(newScoville);
            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {

        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        System.out.println(solution(scoville, 20));


    }
}
