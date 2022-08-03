package inflearn.dfsBfs;

import java.util.Scanner;

public class 피모나치수열_메모이제이션 {

    static int[] fibo;

    public int DFS(int n) {

        if(fibo[n]>0) return fibo[n];
        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n - 2) + DFS(n - 1);

    }

    public static void solution(int n) {

        fibo = new int[n + 1];
        피모나치수열_메모이제이션 sol = new 피모나치수열_메모이제이션();
        int dfs = sol.DFS(n);
        System.out.println("dfs = " + dfs);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }


}
