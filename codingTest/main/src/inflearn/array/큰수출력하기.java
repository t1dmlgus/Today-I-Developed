package inflearn.array;

import java.util.Scanner;

/**
 *
 * 큰 수 출력하기
 *
 * 문제 : 자신의 바로 앞 수보다 큰 수만 출력하는 프로그럄을 작성하라
 *
 * 입력 >
 * 7 3 9 5 6 12
 *
 *
 */


public class 큰수출력하기 {

    public static void solution(int[] arr) {

        String answer = "";

        int tar = 0;


        for (int i = 0; i < arr.length; i++) {
            if(tar < arr[i])
                answer += arr[i];

            tar = arr[i];
        }

        System.out.println("answer = " + answer);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        큰수출력하기.solution(arr);

    }
}
