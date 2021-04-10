package com.kyle.practicealgorithm.programmers;

import java.util.Arrays;

public class IntegerTriangle {


    public static int solution(int[][] triangle) {
        int answer = 0;
        int maxRow = triangle.length;

        int[][] summedTriangle = new int[maxRow][maxRow];//최대 행만큼 최대 열의 크기이므로 맥스가 될 수 있는 행으로 사이즈를 미리 만든다

        summedTriangle[0][0] = triangle[0][0];
        for (int i = 1; i < maxRow; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    summedTriangle[i][j] = triangle[i][j] + summedTriangle[i - 1][j];
                    continue;
                }
                if (j == triangle[i].length - 1) {
                    summedTriangle[i][j] = triangle[i][j] + summedTriangle[i - 1][j - 1];
                    continue;
                }
                summedTriangle[i][j] = triangle[i][j] + Math.max(summedTriangle[i - 1][j - 1], summedTriangle[i - 1][j]);
            }
        }

        for (int i = 0; i < summedTriangle[maxRow - 1].length; i++) {
            answer = answer < summedTriangle[maxRow - 1][i] ? summedTriangle[maxRow - 1][i] : answer;
        }


        return answer;
    }


    //다른 풀이
    public static int solution2(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
        }

        //stream을 통한 최대값
        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }


    public static void main(String[] args) {
        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));

    }
}
