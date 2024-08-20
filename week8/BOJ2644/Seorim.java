package week8.BOJ2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        System.out.println(relatives(p1, p2, n));
    }

    static int relatives(int start, int target, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        q.add(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int curr = polled[0];
            int dist = polled[1];

            if (curr == target) {
                return dist;
            }

            for (int next: graph[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, dist + 1});
                }
            }
        }

        return -1;
    }

}
