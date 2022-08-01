package inflearn.string;

import java.util.Scanner;


/**
 *
 *
 *  >> #****###**#####**#####**##**
 *
 */



public class 암호 {


    public static void solution(String str) {

        int n = str.length() / 7;

        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = str.substring(0, 7)
                    .replace("#", "1")
                    .replace("*", "0");
            str = str.substring(7);

            int i1 = Integer.parseInt(tmp, 2);
            answer += (char) i1;

        }

        System.out.println("answer = " + answer);





    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        암호.solution(next);

    }
}
