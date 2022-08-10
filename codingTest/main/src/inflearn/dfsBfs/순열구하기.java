package inflearn.dfsBfs;

import java.util.Scanner;

/**
 *
 3 2
 3 6 9

 *
 */

public class 순열구하기 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        순열구하기.solution(m);
    }

    static int[] arr;
    static int[] ch = new int[3];
    static int[] pm;

    private static void solution(int m){
        pm = new int[m];

        dfs(0);
    }

    private static void dfs(int L) {

        if(L == pm.length){
            for (int x : pm) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
        else {
            for (int i = 0; i < arr.length; i++) {

                if(ch[i] == 0){
                    ch[i] = 1;
                    pm[L] = arr[i];
                    dfs(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
