package programmers.Lv1;

import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.Arrays;

public class Sol01 {


    public int[] solution(int[] arr) {

        ArrayList<Integer> ar = new ArrayList<>();

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] != arr[i + 1]) {
                ar.add(arr[i]);
            }

        }
        ar.add(arr[arr.length-1]);

        return ar.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {


//        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] arr = {4, 4, 4, 3, 3};

        Sol01 sol01 = new Sol01();
        sol01.solution(arr);
    }
}
