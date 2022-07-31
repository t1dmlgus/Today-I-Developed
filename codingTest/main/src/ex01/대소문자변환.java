package ex01;

import java.util.Scanner;

public class 대소문자변환 {


    public static String solution(String str){

        StringBuilder answer = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer.append(Character.toUpperCase(c));
            }else{
                answer.append(Character.toLowerCase(c));
            }
        }
        return answer.toString();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String next = sc.next();

        String solution = 대소문자변환.solution(next);
        System.out.println("solution = " + solution);
    }
}
