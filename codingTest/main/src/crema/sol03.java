package crema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sol03 {

    static int[] ch;
    static List<Integer> arr;
    static int kk;
    static int max = Integer.MIN_VALUE;

    public static void solution(List<Integer> a, int k){

        arr = a;
        int length = arr.size();
        ch = new int[length + 1];
        kk = k;

        dfs(1);
        System.out.println("max = " + max);

    }

    private static void dfs(int L) {
        int answer = 0;
        int count = 0;
        if (L == ch.length) {
            for (int i = 0; i < ch.length-1; i++) {
                if (ch[i+1] != 0) {
                    answer += arr.get(i);
                    count++;
                }
            }
            if (answer <= kk) {
                max = Math.max(max, count);
            }
        }else {
            ch[L] = 1;
            dfs(L+1);
            ch[L] = 0;
            dfs(L+1);
        }

    }

    public static void main(String[] args) {

        arr = List.of(3, 1, 2, 1);
        sol03.solution(arr, 4);

    }
}
