package inflearn.sorting;

import java.util.Scanner;


/**
 *
 6
 13 5 11 7 23 15
 *
 *
 */


public class 선택정렬 {


    public static void solution(int[] arr) {

        int idx = 0;
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        선택정렬.solution(arr);



    }
}
