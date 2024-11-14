package week11.BOJ2211;

import java.io.*;
import java.util.*;

public class Seorim {

    static List<int[]>[] graph;
    static int n, m;
    static boolean[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, cost});
            graph[v].add(new int[] {u, cost});
        }

        int[] prevNode = dijkstra();
        path = new boolean[n+1][n+1];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            cnt += dfs(i, prevNode);
        }

        bw.write(cnt + "\n");
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (path[i][j]) {
                    bw.write(i + " " + j + "\n");
                }
            }
        }

        bw.flush();
    }

    static int[] dijkstra() {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, 10 * 1000 + 1);

        int[] prevNode = new int[n+1];
        prevNode[1] = 0;

        q.add(new int[]{1, 0});
        dist[1] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (visited[curr[0]]) continue;

            visited[curr[0]] = true;

            for (int[] edge : graph[curr[0]]) {
                int next = edge[0];
                int cost = edge[1];
                if (!visited[next] && dist[curr[0]] + cost < dist[next]) {
                    dist[next] = dist[curr[0]] + cost;
                    q.add(new int[]{next, dist[next]});
                    prevNode[next] = curr[0];
                }
            }
        }

        return prevNode;
    }

    static int dfs(int curr, int[] prevNode) {
        if (curr == 1 || path[curr][prevNode[curr]]) return 0;

        path[curr][prevNode[curr]] = true;
        path[prevNode[curr]][curr] = true;

        return dfs(prevNode[curr], prevNode) + 1;
    }

}
