package inflearn.dfsBfs;

import java.util.Arrays;
import java.util.Collections;

public class 동전교환 {

    static Integer[] arr;
    static int SUM = 0;
    static int answer = Integer.MAX_VALUE;


    public static void dfs(int L, int sum) {

        Arrays.sort(arr, Collections.reverseOrder());

        if(sum>15) return;
        if(L>answer) return;
        if (sum == 15) {
            answer = Math.min(answer, L);
        }else {
            for (int i = 0; i < arr.length; i++) {
                dfs(L + 1, sum+arr[i]);
            }
        }

    }

    public static void solution(){

        arr = new Integer[]{1, 2, 5};

        dfs(0, 0);
        System.out.println("answer = " + answer);
    }


    public static void main(String[] args) {

        동전교환.solution();
    }
}
