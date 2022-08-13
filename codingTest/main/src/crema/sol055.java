package crema;

import java.util.*;


/**
 *
 1 2
 2 3
 2 4
 1 5
 *
 *
 *
 */



public class sol055 {

    static int[] ch, dis;
    static List<List<Integer>> edge;

    public static void solution(List<List<Integer>> arr, int n){

        edge = arr;
        ch = new int[n+1];
        dis = new int[n+1];

        bfs(1);
        for (int di : dis) {
            System.out.println("di = " + di);
        }
    }

    private static void bfs(int v) {

        Queue<Integer> que = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        que.offer(v);
        while (!que.isEmpty()) {
            int cv = que.poll();
            for (int nv : edge.get(cv)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    que.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        edge = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edge.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edge.get(a).add(b);

        }

        int k = 5;
        sol055.solution(edge, k);
    }
}
