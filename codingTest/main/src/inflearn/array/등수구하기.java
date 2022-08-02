package inflearn.array;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 87 89 92 100 76
 *
 */
public class 등수구하기 {


    public static void solution(int[] arr) {

        int[] answers = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    cnt++;
                }
            }
            answers[i] = cnt;
        }

        System.out.println("answers = " + Arrays.toString(answers));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        등수구하기.solution(arr);

    }
}
