package inflearn.string;

import java.util.Scanner;

/**
 * 문제: 주어진 문자열 중, 숫자만 추출하여 자연수를 만들어라
 *
 * 입력 : g0en2T0s8eSoft
 *
 *
 */


public class 숫자만추출 {

    public static void solution(String str) {

        String s = str.replaceAll("[^0-9]", "");
        int i = Integer.parseInt(s);
        System.out.println("i = " + i);
    }

    public static void solution2(String str) {

        int answer = 0;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if(Character.isDigit(aChar))
                answer = answer * 10 + (aChar - 48);

        }
        System.out.println("answer = " + answer);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        숫자만추출.solution2(next);
    }
}
