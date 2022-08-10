package inflearn.dfsBfs;

import java.util.Scanner;

public class 조합 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        조합.solution(n, r);
    }

    static int[][] arr;

    private static void solution(int n, int r) {

        arr = new int[33][33];
        int dfs = dfs(n, r);
        System.out.println("dfs = " + dfs);
    }

    private static int dfs(int n, int r) {

        if(arr[n][r]!=0) return arr[n][r];
        if(r == 0 || n == r) return 1;
        else {
            return arr[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        }

    }
}
