package inflearn.array;

import java.util.Scanner;

/**
 *
 * 1 0 1 1 1 0 0 1 1 0
 */


public class 점수계산 {

    public static void solution(int[] arr) {


        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                count = count + 1;
            }else{
                count = 0;
            }
            sum += count;
        }

        System.out.println("sum = " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        점수계산.solution(arr);

    }
}
