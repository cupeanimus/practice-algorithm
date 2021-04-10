package com.kyle.practicealgorithm.programmers;

public class IntegerTriangle {


    public static int solution(int[][] triangle) {
        int answer = 0;
        int maxRow = triangle.length;

        int[][] summedTriangle = new int[maxRow][maxRow];//최대 행만큼 최대 열의 크기이므로 맥스가 될 수 있는 행으로 사이즈를 미리 만든다

        summedTriangle[0][0] = triangle[0][0];
        for (int i = 1; i <maxRow ; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j==0){
                    summedTriangle[i][j] = triangle[i][j] + summedTriangle[i-1][j];
                    continue;
                }
                if (j == triangle[i].length-1){
                    summedTriangle[i][j] = triangle[i][j] + summedTriangle[i-1][j-1];
                    continue;
                }
                summedTriangle[i][j] = triangle[i][j] + Math.max(summedTriangle[i-1][j-1],summedTriangle[i-1][j]);
            }
        }

        for (int i = 0; i < summedTriangle[maxRow-1].length; i++) {
            answer = answer<summedTriangle[maxRow-1][i]?summedTriangle[maxRow-1][i] : answer;
        }


        return answer;
    }


    public static void main(String[] args) {
        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));

    }
}
