package inflearn.array;

import java.util.Scanner;

/**
 *
 * 8
 * 130 135 148 140 145 150 150 153
 */


public class 보이는학생 {

    public static void solution(int[] arr) {

        int tar = 0;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if(tar < arr[i]){
                count++;
                tar = arr[i];
            }

        }
        System.out.println("count = " + count);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        보이는학생.solution(arr);
    }
}
