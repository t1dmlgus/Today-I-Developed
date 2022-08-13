package iportfolio;

import java.util.Arrays;

public class sol01 {

    public int solution(int n){

        int answer = -1;

        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                arr[i] = 1;
            }
            if (i % 3 == 0) {
                if (arr[i] == 1) {
                    arr[i] = 0;
                }else {
                    arr[i] = 1;
                }
            }
        }

        for (int i : arr) {
            if(i == 0)
                answer++;
        }


        return answer;
    }


    public static void main(String[] args) {

        // 조건
        int n = 2;

        sol01 sol01 = new sol01();

        System.out.println("sol01.solution(n) = " + sol01.solution(n));
    }
}
