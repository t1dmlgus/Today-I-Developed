package inflearn.stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * (())()
 *
 */


public class 올바른괄호 {


    public static void solution(String str) {

        String answer = "yes";
        Stack<Character> st = new Stack<>();

        char[] x = str.toCharArray();
        for (char c : x) {
            if (c == '(')
                st.push(c);
            else {
                if(st.isEmpty()) answer = "No";
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        if (!st.isEmpty()) {
            answer = "No";
        }
        // st 남아 있을 경우
        // st에 없는데 빼는 경우
        System.out.println("answer = " + answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        올바른괄호.solution(next);

    }
}
