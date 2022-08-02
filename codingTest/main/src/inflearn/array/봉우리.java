package inflearn.array;

import java.util.Scanner;

/**
 *
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2
 *
 *
 *
 *
 */




public class 봉우리 {

    public void solution(int[][] arr) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                int nx = 0;
                int ny = 0;
                int k = 0;

                for (k = 0; k < 4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];

                    if (nx > -1 && ny > -1 && nx < arr.length && ny < arr.length && arr[i][j] < arr[nx][ny]) {
                        break;
                    }
                }
                if(k == 4)
                    count++;
            }
        }
        System.out.println("count = " + count);


    }


    public static void main(String[] args) {

        봉우리 봉우리 = new 봉우리();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        봉우리.solution(arr);
    }
}
