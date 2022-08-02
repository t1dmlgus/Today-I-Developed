package inflearn.twoPointerAndSlidingWindow;

import java.util.Scanner;

public class 공통원소구하기 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i=0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int t = sc.nextInt();
        int[] arr2 = new int[t];
        for (int i=0; i < t; i++) {
            arr1[i] = sc.nextInt();
        }


    }
}
