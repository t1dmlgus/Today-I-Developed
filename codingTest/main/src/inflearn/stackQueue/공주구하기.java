package inflearn.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주구하기 {


    public static void solution(int num) {

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= num; i++) {
            queue.offer(i);
        }
        int count = 0;

        while (queue.size() != 1){
            Integer pop = queue.pop();
            count++;
            if (count == 3) {
                count = 0;
                continue;
            }
            queue.offer(pop);
        }

        Integer peek = queue.peek();
        System.out.println("peek = " + peek);


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        공주구하기.solution(n);

    }
}
