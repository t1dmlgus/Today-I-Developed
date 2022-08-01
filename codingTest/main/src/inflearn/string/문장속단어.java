package inflearn.string;


import java.util.Scanner;

/**
 * 문제>
 *
 * 한 개의 문장이 주어지면, 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하라
 * (문장 속 각 단어는 공백으로 구분된다.)
 *
 *
 * ex) it is time to study
 *
 * >> study
 *
 *
 *
 */


public class 문장속단어 {


    public static void solution(String str){

        int length = 0;
        String maxStr = "";
        int pos = 0;


//        for (String s1 : str.split(" ")) {
//            if (s1.length() > length) {
//                length = s1.length();
//                maxStr = s1;
//            }
//        }

        // indexOf, substring

        while ((pos = str.indexOf(' ')) != -1) {
            if (pos > length) {
                maxStr = str.substring(0, pos);
                length = pos;
            }
            str = str.substring(pos+1);
        }
        if(str.length() > length)
            maxStr = str;


        System.out.println("maxStr = " + maxStr);

    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();

        문장속단어.solution(next);
    }
}
