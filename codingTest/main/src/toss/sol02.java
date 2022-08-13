package toss;

public class sol02 {

    public static int solution(int[] levels) {

        int answer = -1;
        int length = levels.length;
        double vv = length * 0.25;

        if(length % 4 ==0){
            for (int level : levels) {
                if(vv < level){
                    return answer = level;
                }
            }
        }else {
            for (int level : levels) {
                if(vv < level){
                    
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int solution = sol02.solution(arr);
        System.out.println("solution = " + solution);
    }
}
