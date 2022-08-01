package inflearn.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 한개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소 거리를 출력하는 프로그램을 작성하라
 *
 * 입력 : teachermode e
 *
 *
 *
 *
 *
 *
 */




public class 가장짧은문자거리 {

    public static void solution(String str) {

        int[] strs = new int[str.length()];
        int index = 1000;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'e') {
                index = 0;
            }
            strs[i] = index;
            index++;
        }

        for (int i = str.length()-1; i >= 0; i--) {

            if (str.charAt(i) == 'e') {
                index = 0;
            }
            if (strs[i] > index) {
                strs[i] = index;
            }
            //strs[i] = Math.min(strs[i], index);

            index++;
        }


    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        가장짧은문자거리.solution(nextLine);
    }
}
