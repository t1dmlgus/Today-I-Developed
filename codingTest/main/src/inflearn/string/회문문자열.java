package inflearn.string;

import java.util.Scanner;

/**
 *
 * 문제 : 회문문자열을 찾아라
 *
 * 입력 : gooG
 *
 *
 * 문제 : 팰린드롬(알파벳 외 제외, 알파벳만으로 회문문자열을 찾아라)
 *
 * 입력 : found7, time: study; Yduts; emit, 7Dnuof
 *
 *
 *
 */



public class 회문문자열 {

    public static boolean solution(String str) {

        int k = str.length() / 2;
        char[] strs = str.toUpperCase().toCharArray();
        int lt = 0;
        int rt = str.length()-1;

        while (lt < k) {
            if(strs[lt] != strs[rt])
                return false;
            lt++;
            rt--;
        }
        return true;
    }


    public static void solution2(String str){

        str = str.replaceAll("[^A-z]", "").toUpperCase();

        StringBuilder sb = new StringBuilder(str);
        StringBuilder reverseStr = sb.reverse();
        if(str.equals(sb.toString())){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        회문문자열.solution2(next);
    }
}
