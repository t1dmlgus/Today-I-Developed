package programmers.Lv1;

import java.util.ArrayList;

public class Sol02 {


    public long solution(int a, int b) {

        long answer = 0;

        if (a < b) {
            for (int i = a; i <= b; i++) {
                answer += i;
            }
        } else if (a == b) {
            answer = a;
       } else {
            for (int i = a; i >= b; i--) {
                answer += i;
            }
        }

        System.out.println("answer = " + answer);
        return answer;
    }


    public static void main(String[] args) {


        int a = 3;
        int b = 5;

        Sol02 sol02 = new Sol02();
        sol02.solution(a, b);
    }
}
