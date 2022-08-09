package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * 5
 1 4
 2 3
 3 5
 4 6
 5 7

 3 3
 1 3
 2 3
 *
 */


public class 회의실배정 {

    public class Sr implements Comparable<Sr>{

        int x;
        int y;

        public Sr(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Sr o) {
            return this.y - o.y;
        }

        @Override
        public String toString() {
            return x+" "+y;
        }
    }


    public void solution(int[][] arr) {

        ArrayList<Sr> ar = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            ar.add(new Sr(arr[i][0], arr[i][1]));
        }
        Collections.sort(ar);

        int time = ar.get(0).y;
        int count = 1;
        for (Sr sr : ar) {
            if (time <= sr.x) {
                time = sr.y;
                count++;
            }
        }

        System.out.println("count = " + count);
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        회의실배정 회의실배정 = new 회의실배정();
        회의실배정.solution(arr);
    }
}
