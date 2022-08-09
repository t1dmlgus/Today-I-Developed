package inflearn.greedy;

import java.util.Scanner;

/**
 *
 * 5
 172 67
 183 65
 180 70
 170 72
 181 60
 *
 *
 *
 */


public class 씨름선수 {


    public static int solution(int[][] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    count++;
                    break;
                }
            }
        }

        return arr.length - count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int solution = 씨름선수.solution(arr);
        System.out.println("solution = " + solution);

    }
}
