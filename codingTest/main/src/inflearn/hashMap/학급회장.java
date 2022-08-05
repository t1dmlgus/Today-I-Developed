package inflearn.hashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * BACBACCACCBDEDE
 *
 */

public class 학급회장 {

    public static void solution(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        char[] x = str.toCharArray();
        for (char c : x) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        char maxKey = 0;
        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            if (max < value) {
                max = value;
                maxKey = key;
            }
        }
        System.out.println("maxKey = " + maxKey);

    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        String next = sc.next();
        
        학급회장.solution(next);
    }
}
