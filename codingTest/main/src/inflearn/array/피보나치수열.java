package inflearn.array;

import java.util.Scanner;

public class 피보나치수열 {
    public static void solution(int n) {

        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;


        for (int i = 2; i < n; i++) {
            answer[i] = answer[i-2]+ answer[i-1] + answer[i];
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        피보나치수열.solution(n);

    }
}
