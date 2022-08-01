package inflearn.string;

import java.util.Scanner;


/**
 *
 * 문제: 소문자로 이루어진 문자열 중 중복된 문자를 제거하고 출력하라
 *
 * 입력 > ksekkset
 *
 *
 *
 */


public class 중복문자제거 {

    public static void solution(String str) {

        String answer = "";

        for (int i = 0; i < str.length(); i++) {

            if (i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }

        }
        System.out.println("answer = " + answer);
    }



    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        중복문자제거.solution(next);
    }
}
