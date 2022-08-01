package inflearn.string;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * N개의 단어가 주어지면, 각 단어를 뒤집어 출력하는 프로그램을 작성하라
 *
 * > 3
 * > good
 * > time
 * > Big
 *
 *
 *
 *
 *
 */


public class 단어뒤집기 {


    public static void solution(String[] str) {

        ArrayList<String> strReverse = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        for (String s : str) {
//            StringBuilder stringBuilder = new StringBuilder(s);
//            StringBuilder reverse = stringBuilder.reverse();
//            strReverse.add(reverse.toString());
//        }

        for (String s : str) {

            int lt = 0;
            int rt = s.length()-1;
            char tmp;

            char[] x = s.toCharArray();

            while (lt <= rt) {
                tmp = x[rt];
                x[rt] = x[lt];
                x[lt] = tmp;

                lt++;
                rt--;
            }
            strReverse.add(String.valueOf(x));
        }


        for (String s : strReverse) {
            System.out.println("s = " + s);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        단어뒤집기.solution(str);
    }
}
