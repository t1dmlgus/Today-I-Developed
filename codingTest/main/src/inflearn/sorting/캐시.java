package inflearn.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 *
 9
 1 2 3 2 6 2 3 5 7
 *
 *
 */
public class 캐시 {


    public static void solution(int[] arr) {

        int[] cache = new int[5];


        for (int x : arr) {
            int tmp = -1;
            for (int i = 0; i < cache.length; i++) {
                if (cache[i] == x) {
                    tmp = i;
                }
            }

            if (tmp == -1) {
                for (int i = cache.length - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }else {
                for (int i = tmp; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        System.out.println("Arrays.toString(cache) = " + Arrays.toString(cache));



    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        캐시.solution(arr);

    }
}
