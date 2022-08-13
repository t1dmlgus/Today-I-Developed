package crema;

import java.util.Scanner;

public class sol01 {

    public static String solution(String s){

        String answer = "";

        if(!s.contains("AWS")) return s;
        while (s.contains("AWS")) {
            char[] x = s.toCharArray();

            for (int i = 0; i < x.length; i++) {
                if (x[i] == 'A' && x[i + 1] == 'W' && x[i + 2] == 'S') {
                    i = i + 2;
                }else
                    answer += x[i];
            }
            s = answer;
            answer = "";
        }
        if(s.equals("")) return "-1";
        else return s;

    }

    public static void main(String[] args) {
//        String s = "AWAWSSG";
//        String s = "ABCDWS";
        String s = "AAWSWS";
        System.out.println("s = "+ sol01.solution(s));;
    }
}
