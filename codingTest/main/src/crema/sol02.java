package crema;

import java.util.Arrays;
import java.util.Scanner;

public class sol02 {

    public static long solution(int num){

        String s = String.valueOf(num);

        int max = getMax(s.toCharArray());
        int min = getMin(s.toCharArray());

        return max - min;
    }

    private static int getMin(char[] x) {
        char tmp ='0';
        if (x[0] == '1') {
            for (int i = 1; i < x.length; i++) {
                while (x[i] != '0') {
                    if(tmp != '0') break;
                    tmp = x[i];
                    x[i] = '0';
                }
                if (x[i] == tmp) {
                    x[i] = '0';
                }
            }

        }else {
            tmp = x[0];
            x[0] = '1';

            for (int i = 1; i < x.length; i++) {
                if (x[i] == tmp) {
                    x[i] = '1';
                }
            }
        }

        return Integer.parseInt(String.valueOf(x));
    }

    private static int getMax(char[] x) {
        char tmp='0';

        if (x[0] == '9') {
            for (int i = 1; i < x.length; i++) {
                while (x[i] != '9') {
                    if(tmp != '0') break;
                    tmp = x[i];
                    x[i] = '9';
                }
                if (x[i] == tmp) {
                    x[i] = '9';
                }
            }
        }else{
            tmp = x[0];
            x[0] = '9';

            for (int i = 1; i < x.length; i++) {
                if (x[i] == tmp) {
                    x[i] = '9';
                }
            }
        }

        return Integer.parseInt(String.valueOf(x));
    }

    public static void main(String[] args) {

        int num = 909;
        System.out.println(sol02.solution(num));;

    }
}
