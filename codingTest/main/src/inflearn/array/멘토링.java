package inflearn.array;

import java.util.Scanner;

public class 멘토링 {

    public static void solution(int[][] arr) {

        int tar = 0;

        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr[i].length; k++) {


                }
            }
        }

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
        멘토링.solution(arr);

    }
}
