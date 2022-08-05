package inflearn.array;

import java.util.Scanner;


/**
 10 13 10 12 15
 12 39 30 23 11
 11 25 50 53 15
 19 27 29 37 27
 19 13 30 13 19
 *
 *
 */


public class 격자판최대합 {


    public static void solution(int[][] arr){

        int answer = 0;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < arr.length; i++) {
            sum1=sum2=0;
            for (int j = 0; j < arr[i].length; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][arr.length - i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);


        System.out.println("answer = " + answer);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        격자판최대합.solution(arr);
    }
}
