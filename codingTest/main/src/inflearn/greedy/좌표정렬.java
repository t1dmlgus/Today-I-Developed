package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * 5
 2 7
 1 3
 1 2
 2 5
 3 6
 *
 *
 */


public class 좌표정렬 {


    public class TT implements Comparable<TT>{

        int x;
        int y;

        public TT(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(TT o) {

            if(this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }



    public void solution(int[][] arr) {

        ArrayList<TT> ar = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            ar.add(new TT(arr[i][0], arr[i][1]));
        }
        Collections.sort(ar);

        for (TT tt : ar) {
            System.out.println("tt = " + tt);
        }

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
        좌표정렬 pp = new 좌표정렬();
        pp.solution(arr);
    }
}
