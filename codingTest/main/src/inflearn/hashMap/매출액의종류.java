package inflearn.hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * 7
 * 20 12 20 10 23 17 10
 */


public class 매출액의종류 {


    public static void solution(int[] arr) {

        int k = 4;
        int cnt = 0;

        ArrayList<Integer> ar = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int lt = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            cnt++;
            if(cnt < k+1)
                map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            else {
                ar.add(map.size());
                map.clear();
                cnt = 0;
                rt -= k;
            }
        }
        ar.add(map.size());
        System.out.println("ar = " + ar);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        매출액의종류.solution(arr);


    }
}
