package inflearn.hashMap;

import java.util.*;


/**
 * 10
 * 13 15 34 23 45 65 33 11 26 42
 *
 */
public class K번째큰수 {


    public static void solution(int[] arr) {

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            for(int j = i+1; j<arr.length; j++){
                for (int z = j + 1; z < arr.length; z++) {
                    set.add(arr[i] + arr[j] + arr[z]);
                }
            }
        }


        System.out.println("set.toString() = " + set.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        K번째큰수.solution(arr);
    }
}
