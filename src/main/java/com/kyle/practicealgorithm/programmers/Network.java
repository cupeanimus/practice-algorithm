package com.kyle.practicealgorithm.programmers;

/*프로그래머스 > 깊이/너비 우선탐색(DFS/BFS) > 네트워크
문제 설명
네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.

컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.

제한사항
컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
computer[i][i]는 항상 1입니다.

풀이방
즉 연결된 것을 하나로 간주하고
연결되지 않은 개수를 구하는 것이다.
이것도 재귀함수로 하여 연결된 부분까지 접근하여 끊어지지 않은 수를 구하면 될 것 같다.


 */
public class Network {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        //default false
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!check[i]){
                networkCountDfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }

    private static boolean[] networkCountDfs(int[][] computers, int i, boolean[] check) {
        check[i] = true;

        for (int j = 0; j < computers.length; j++) {
            //연결된 부분중에 연결 체크를 하지 않은 녀석이 있으면 체크해본다
            //하지만 이럴때 1과 2가 연결 된 상태에서 2를 중복하지 않을까 하는 우려가 있었는데 해당 카운트는 solution메소드에서 체크하고
            //연결된 여기서 true로 같은 영역으로 수정하여 해결한다
            if (i != j && computers[i][j] == 1 && check[j]==false){
                check = networkCountDfs(computers, j, check);
            }
        }
        return check;
    }

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        solution(3, computers);
    }


}