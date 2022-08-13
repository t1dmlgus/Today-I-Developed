package programmers.완전탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 모의고사 {


    public int[] solution(int[] answers){

        int[] k = {1, 2, 3, 4, 5};
        int[] k2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] k3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < answers.length; i++) {

            if (answers[i] == k[i % k.length]) {
                map.put(1, map.getOrDefault(1, 0)+1);
            }
            if (answers[i] == k2[i % k2.length]) {
                map.put(2, map.getOrDefault(2, 0)+1);
            }
            if (answers[i] == k3[i % k3.length]) {
                map.put(3, map.getOrDefault(3, 0)+1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                arr.add(key);
            }
        }


        return arr.stream()
                .mapToInt(i-> i)
                .toArray();
    }


    public static void main(String[] args) {

        int[] answer = {1, 2, 3, 4, 5};

        모의고사 모의고사 = new 모의고사();
        int[] solution = 모의고사.solution(answer);
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }
}
