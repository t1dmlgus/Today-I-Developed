package inflearn.twoPointerAndSlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

// twoPoint
public class 연속된자연수합 {

    public static void solution(int n) {

        int answer = 0;

        int cnt = 1;
        n--;
        while (n > 0) {
            cnt++;
            n -= cnt;
            if(n%cnt==0) answer++;
        }

        System.out.println("answer = " + answer);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        연속된자연수합.solution(n);
    }
}
