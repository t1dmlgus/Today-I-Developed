package inflearn.dfsBfs;

import java.util.Scanner;

/**
 *
 0 0 0 0 0 0 0
 0 1 1 1 1 1 0
 0 0 0 1 0 0 0
 1 1 0 1 0 1 1
 1 1 0 0 0 0 1
 1 1 0 1 1 0 0
 1 0 0 0 0 0 0
 *
 *
 *
 *
 */

public class 미로탐색 {


    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] arr;
    public static int answer = 0;

    public void dfs(int x, int y) {

        if(x == 7 && y == 7) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= 7 && ny <= 7 && arr[nx][ny] == 0) {
                    arr[nx][ny] =1;
                    dfs(nx, ny);
                    arr[nx][ny] = 0;
                }
            }
        }
    }


    public static void solution(int[][] arr) {

        arr[1][1] = 1;
        미로탐색 aa = new 미로탐색();
        aa.dfs(1, 1);

        System.out.println("answer = " + answer);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n+1][n+1];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        미로탐색.solution(arr);
    }
}
