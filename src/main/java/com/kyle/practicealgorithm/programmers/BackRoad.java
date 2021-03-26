package com.kyle.practicealgorithm.programmers;

/*계속되는 폭우로 일부 지역이 물에 잠겼습니다. 물에 잠기지 않은 지역을 통해 학교를 가려고 합니다. 집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다.

아래 그림은 m = 4, n = 3 인 경우입니다.

다음 칸은 주변경로의 합이다.
따라서 주변경로를 더해가며 답을 구하면 된다.

*/
public class BackRoad {

    //효율성이 실패한
    public static int solution(int m, int n, int[][] puddles) {
        int[][] location = new int[n][m];
        for (int[] puddle : puddles) {
            location[puddle[1]-1][puddle[0]-1] = -1;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (location[i][j] == -1){
                    location[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0){
                    location[i][j] =1;
                    continue;
                }

                if (i != 0){
//                    location[i][j] += location[i-1][j];
                    location[i][j] += location[i-1][j] % 1000000007;        //다른 수 입력할때 나머지를 구하는 식을 넣으면 효율성을 통과한다. 왜? 미리 한번 나누는게 이렇게나 큰 차이를 일으키는지 이해가 안간다.
                }
                if (j != 0){
//                    location[i][j] += location[i][j-1];
                    location[i][j] += location[i][j-1] % 1000000007;
                }

            }
        }


        return location[n-1][m-1] % 1000000007;
    }

    public static void main(String[] args) {
        int[][] puddles = new int[][]{{2,2}};

        System.out.println(solution(4,3, puddles));


    }
}
