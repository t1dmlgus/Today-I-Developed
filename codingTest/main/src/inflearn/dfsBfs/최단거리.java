package inflearn.dfsBfs;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class 최단거리 {


    public static int[][] arr;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int min = 49;

    private static void dfs(int x, int y, int count) {

        if (x == 7 && y == 7) {
            min = Math.min(min, count);
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && nx < 8 && ny >= 1 && ny < 8 && arr[nx][ny] == 0) {
                arr[nx][ny] = 1;
                count++;
                dfs(nx, ny, count);
                count--;
                arr[nx][ny] = 0;
            }

        }



    }

    public static void solution() {

        arr[1][1] = 1;
        int count = 0;
        dfs(1, 1, count);

        System.out.println("min = " + min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        최단거리.solution();
    }
}
