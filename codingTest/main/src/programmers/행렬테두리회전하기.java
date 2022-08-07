package programmers;

import java.util.Arrays;

public class 행렬테두리회전하기 {
    int[][] board;

    public int[] solution(int rows, int columns, int[][] queries) {

        int[] answer = new int[queries.length];
        board = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j =0; j < columns; j++) {
                board[i][j] = (i*columns + j +1);
            }
        }

        for(int k = 0; k< queries.length; k++){
            int rotation = rotation(queries[k][0] - 1, queries[k][1] - 1, queries[k][2] - 1, queries[k][3] - 1);
            answer[k] = rotation;
        }

        return answer;
    }



    public int rotation(int x1, int y1, int x2, int y2){

        int tmp = board[x1][y1];
        int min = tmp;

        // 왼
        for (int i = x1; i < x2; i++) {
            board[i][y1] = board[i+1][y1];
            min = Math.min(min, board[i][x1]);
        }


        // 아래
        for (int i = y1; i < y2; i++) {
            board[x2][i] = board[x2][i+1];
            min = Math.min(min, board[x2][i]);
        }

        // 오
        for (int i = x2; i > x1; i--) {
            board[i][y2] = board[i-1][y2];
            min = Math.min(min, board[i][y2]);
        }


        // 위
        for (int i = y2; i > y1; i--) {
            board[x1][i] = board[x1][i-1];
            min = Math.min(min, board[x1][i]);
        }

        board[x1][y1 + 1] = tmp;


        return min;
    }



    public static void main(String[] args) {

        int rows = 3;
        int columns = 3;
        //int[][] arr = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[][] arr = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2},{2, 2, 3, 3}};
        //int[][] arr = {{1, 1, 100, 97}};

        행렬테두리회전하기 sol1 = new 행렬테두리회전하기();
        int[] solution = sol1.solution(rows, columns, arr);
        System.out.println(Arrays.toString(solution));
    }
}
