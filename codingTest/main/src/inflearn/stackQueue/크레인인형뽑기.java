package inflearn.stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 5
 0 0 0 0 0
 0 0 1 0 3
 0 2 5 0 1
 4 2 4 4 2
 3 5 1 3 1
 8
 1 5 3 5 1 2 1 4
 *
 *
 *
 *
 */

public class 크레인인형뽑기 {


    public static void solution(int[][] arr, int[] arr2) {

        Stack<Integer> st = new Stack<>();
        int count = 0;

        int tar = 0;
        for (int x : arr2) {
            tar = x;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][tar - 1] != 0) {
                    if (!st.isEmpty() && st.peek() == arr[i][tar - 1]) {
                        st.pop();
                        count += 2;
                    }else {
                        st.push(arr[i][tar - 1]);
                    }
                    arr[i][tar - 1] = 0;
                    break;
                }
            }
        }

        System.out.println("count = " + count);
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

        int k = sc.nextInt();
        int[] arr2 = new int[k];
        for (int i = 0; i < k; i++) {
            arr2[i] = sc.nextInt();
        }

        크레인인형뽑기.solution(arr, arr2);
    }
}
