package week8.BOJ2213;

import java.io.*;
import java.util.*;

public class Seorim {

    static int[] weight;
    static List<Integer>[] graph;
    static int n;

    static boolean[] visited;
    static int[][] dp;
    static List<Integer> path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        weight = new int[n+1];
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        dp = new int[n+1][2];
        visited = new boolean[n+1];
        path = new ArrayList<>();

        dfs(1);

        Arrays.fill(visited, false);
        trace(1, 0);

        bw.write(String.valueOf(Math.max(dp[1][0], dp[1][1])));
        bw.newLine();

        Collections.sort(path);
        for (int x: path) {
            bw.write(x + " ");
        }

        bw.flush();
    }

    static void dfs(int curr) {
        visited[curr] = true;
        dp[curr][1] = weight[curr];

        for (int next: graph[curr]) {
            if (visited[next]) continue;

            dfs(next);

            dp[curr][0] += Math.max(dp[next][0], dp[next][1]); // curr 포함 X
            dp[curr][1] += dp[next][0]; // curr 포함 O
        }
    }

    static void trace(int curr, int parent) {
        if (!visited[parent] && dp[curr][0] < dp[curr][1]) {
            visited[curr] = true;
            path.add(curr);
        }

        for (int next: graph[curr]) {
            if (next != parent) {
                trace(next, curr);
            }
        }
    }

}
