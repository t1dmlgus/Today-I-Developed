package inflearn.stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 */


public class 괄호문자제거 {

    public static void solution(String str) {

        Stack<Character> st = new Stack<>();

        String answer = "";

        char[] x = str.toCharArray();

        for (char c : x) {
            if (c == '(') {
                st.push(c);
            }
            else if(c == ')'){
                if(!st.empty())
                    st.pop();
            }else if(st.isEmpty()){
                answer += c;
            }
        }
        System.out.println("answer = " + answer);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        괄호문자제거.solution(next);


    }
}
