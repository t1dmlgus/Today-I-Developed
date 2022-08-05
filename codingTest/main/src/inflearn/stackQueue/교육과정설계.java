package inflearn.stackQueue;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 CBA
 CABDAGE
 *
 *
 */



public class 교육과정설계 {

    public static String solution(String next, String next2) {

        LinkedList<Character> q = new LinkedList<>();
        String answer = "YES";

        for (char c : next.toCharArray()) {
            q.offer(c);
        }

        for (char x : next2.toCharArray()) {
            if (q.contains(x)) {
                if (x != q.poll()) {
                    return "NO";
                }
            }
        }
        if(!q.isEmpty()) return "NO";
        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String next2 = sc.next();
        System.out.println(교육과정설계.solution(next, next2));

    }
}
