package programmers.완전탐색;

public class 소수찾기 {


    public static int[] ch;
    public static char[] x;
    public static boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;

        x = numbers.toCharArray();
        ch = new int[numbers.length()];
        visited = new boolean[x.length];
        dfs("0");


        return answer;
    }

    private void dfs(String L) {


        int k = Integer.parseInt(L);
        System.out.println("k = " + k);

        for (int i = 0; i < x.length; i++) {

            if(!visited[i]){
                visited[i] = true;
                dfs(L + x[i]);
                visited[i] = false;
            }
        }

    }

    private void isPrime(int i) {


    }

    public static void main(String[] args) {

        소수찾기 소수찾기 = new 소수찾기();

        String numbers = "123";
        소수찾기.solution(numbers);

    }
}
