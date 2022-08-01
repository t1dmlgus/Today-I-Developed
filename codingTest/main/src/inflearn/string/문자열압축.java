package inflearn.string;

import java.util.Scanner;

/**
 *
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우
 * 반복되는 문자 오른쪽에 반복횟수 표기
 *
 * 입력 : KKHSSSSSSSE
 *
 *
 *
 */


public class 문자열압축 {



    public static void solution(String str){

        str = str + " ";
        StringBuilder answer = new StringBuilder();

        int count = 1;
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                count++;
            else {
                answer.append(str.charAt(i));
                if(count > 1) answer.append(count);
                count = 1;
            }
        }
        System.out.println("answer = " + answer);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        문자열압축.solution(next);
    }

}
