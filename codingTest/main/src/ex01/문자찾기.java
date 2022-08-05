package ex01;


import java.util.Scanner;

public class 문자찾기 {


    public static int solution(String str, char c) {

        int answer = 0;

        str = str.toUpperCase();
        c = Character.toUpperCase(c);

//        for (int i = 0; i < str.length(); i++) {
//            if(str.charAt(i) == c)
//                answer++;
//        }

        // 문자열 탐색 -> iterater를 제공하는 collection 프레임워크(list, arraylist), 배열
        for (char x : str.toCharArray()) {
            if(x == c)
                answer++;
        }

        return answer;
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 문자열
        String str = sc.next();

        // 문자 1개
        char c = sc.next().charAt(0);

        int solution = 문자찾기.solution(str, c);
        System.out.println("solution = " + solution);
    }
}
