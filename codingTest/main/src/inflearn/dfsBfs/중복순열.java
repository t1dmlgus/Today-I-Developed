package inflearn.dfsBfs;

import java.util.Scanner;

public class 중복순열 {


    static int[] PM;
    static int N, M;

    public static void dfs(int L) {

        if(L == M){
            for (int i : PM) {
                System.out.print(i+" ");
            }
            System.out.println();
        }else{
            for (int i = 1; i <= N; i++) {
                PM[L] = i;
                dfs(L + 1);
            }
        }
    }


    public static void solution(int n, int m) {

        N = n;
        M = m;
        PM = new int[M];
        dfs(0);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        중복순열.solution(n, m);
    }
}
