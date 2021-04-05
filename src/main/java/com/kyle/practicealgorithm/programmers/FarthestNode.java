package com.kyle.practicealgorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[] c = new boolean[n+1];
        boolean[][] a = new boolean[n+1][n+1];

        for (int i=0; i<edge.length; i++) {
            int a1 = edge[i][0];
            int a2 = edge[i][1];

            a[a1][a2] = true;
            a[a2][a1] = true;
        }

        int v = 0;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        c[1] = true;

        while (!q.isEmpty()) {
            //제일 처음에 들어간 값 꺼내기
            int size = q.size();
            for (int i=0; i<size; i++) {
                v = q.poll();
                for (int j=1; j<=n; j++) {
                    if (a[v][j] && !c[j]) {
                        c[j] = true;
                        q.add(j);
                    }
                }
            }
            answer = size;
        }



        return answer;
    }

    public static void main(String[] args) {

        int[][] edge = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6, edge));

    }
}
