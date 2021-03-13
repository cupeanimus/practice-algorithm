package com.kyle.practicealgorithm.programmers;

/*
* 문제 설명
n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
* -1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
*
* 풀이방향
* 덧셈 뺄셈이면 순서는 상관없다
* 개수만 중요하다
* 그렇다면 답을 계산하는 덧셈 뺄셈 개수를 찾은 후
* 경우의 수를 구하면 된다.
* 즉 순열문제    <-- 해당 부호의 경우의 수만 구하면 되므로 이것은 착각한 부분
*
* 일단 해당 값을 구하려면 + -을 정해야하는데 주어진 수만큼 반복해야할까?
*
* dfs/bfs 문제인 만큼 재귀함수 혹은 스택함수를 사용하라고 한다
* 스택에 대한 이미지가 잘 떠오르지 않으므로 재귀함수를 만들어 풀어보려한다
*
*
* */
public class TargetNumber {
    public static int solution(int[] numbers, int target) {

        int answer = 0;
        return dfsResult(numbers, target, 0, 0);
    }

    private static int dfsResult(int[] numbers, int target, int index, int number) {
        if (numbers.length == index){
            return number == target?1:0;
        } else {
            //이렇게 하면 숫자의 위치는 고려하지않고 각 위치의 +를 할건지 -를 할건지만 정하는것이다.
            //해당수만큼 for문을 도는 것과 같은 형식을 재귀함수로 줄인 방향이다
            return dfsResult(numbers, target, index+1, number + numbers[index])
                    + dfsResult(numbers, target, index+1, number - numbers[index]);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        System.out.println(solution(numbers,3));
    }
}
