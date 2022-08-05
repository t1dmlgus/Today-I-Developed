package inflearn.sorting;

import java.util.Scanner;

/**
 *
 * 9
 * 120 125 152 130 135 135 143 127 160
 *
 */

public class 장난꾸러기 {

    public static void solution(int[] arr) {

        for (int x : arr) {
            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[idx] > arr[i]) {

                }
            }
        }



    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        장난꾸러기.solution(arr);
    }
}
