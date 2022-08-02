package inflearn.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 5
 2 3 1 7 3
 4 1 9 6 8
 5 5 2 4 4
 8 4 2 2 2
 6 5 2 6 7
 *
 *
 *
 */



public class 임시반장정하기 {

    public static void solution(int[][] arr) {

        int[] tmp = new int[arr.length];

        int max = 0;
        int beforeCount = 0;

        // 학생
        for (int i = 0; i < arr.length; i++) {
            // 학년
            for (int k = 0; i < arr.length; i++) {

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

        임시반장정하기.solution(arr);
    }
}
