package inflearn.twoPointerAndSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// twoPoint
public class 두배열합치기 {

    public static void solution(int[] arr1, int[] arr2) {

        ArrayList<Integer> answers = new ArrayList<>();


        int p1 = 0;
        int p2 = 0;


        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) {
                answers.add(arr1[p1]);
                p1++;
            } else {
                answers.add(arr2[p2]);
                p2++;
            }
        }


    }


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

        두배열합치기.solution(arr1, arr2);
    }
}
